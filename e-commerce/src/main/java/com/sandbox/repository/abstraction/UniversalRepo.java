package com.sandbox.repository.abstraction;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.entity.abstraction.Audit;
import com.sandbox.util.mapper.abstraction.ITypeInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

//@Transactional()
//@Component
//@Repository
//@NoRepositoryBean
//@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class UniversalRepo<E> implements IUniversalRepo<E> {

	@PersistenceContext()
	private EntityManager entityManager;

	@Autowired
	private ITypeInfo<E> typeInfoE;

	Class<E> classE;

	@Autowired
	private Map<String, JpaRepository<? extends Audit, String>> repositories;

	public UniversalRepo(Class<E> classE) {
		super();
		this.classE = classE;
	}

	@Override
	public Class<E> getTypeClass() {
		return classE;
	}

	private TypedQuery<E> setAllParametersQuery(TypedQuery<E> query, Map<String, String> foreignKeysMap) {

		List<Field> foriegnKeysFields = typeInfoE.getForeignKeyFields();

		for (Entry<String, String> entry : foreignKeysMap.entrySet()) {
			System.out.println(
					"Name of class : " + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1));
			JpaRepository<? extends Audit, String> repo = repositories.get(entry.getKey());
			System.out.println("foriegnKeysFields : " + foriegnKeysFields);
			Optional<Field> field = Optional.empty();
			try {
				field = foriegnKeysFields.stream().filter(f -> f.getName().equals(entry.getKey())).findFirst();
			} catch (NoSuchElementException e) {
//				e.fillInStackTrace();

			}
			System.out.println("name of field : " + entry.getKey());
			if (field.isPresent()) {
				System.out.println("found field : " + field.get());
				String name = field.get().getName();
				System.out.println("name of field : " + name);

				if (repo != null) {
					System.out.println("repo : " + repo.toString());
					Optional<? extends Audit> entity = repo.findById(entry.getValue());
					if (entity.isPresent()) {
						System.out.println("found entity : " + entity.get());
						query.setParameter(name, entity.get());
					}
				}

			} else {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return query;
	}

	private TypedQuery<Long> setAllParametersQueryForCount(TypedQuery<Long> query, Map<String, String> foreignKeysMap) {

		List<Field> foriegnKeysFields = typeInfoE.getForeignKeyFields();

		for (Entry<String, String> entry : foreignKeysMap.entrySet()) {
			System.out.println(
					"Name of class : " + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1));
			JpaRepository<? extends Audit, String> repo = repositories.get(entry.getKey());
			System.out.println("foriegnKeysFields : " + foriegnKeysFields);
			Optional<Field> field = Optional.empty();
			try {
				field = foriegnKeysFields.stream().filter(f -> f.getName().equals(entry.getKey())).findFirst();
			} catch (NoSuchElementException e) {

			}
			System.out.println("name of field : " + entry.getKey());
			if (field.isPresent()) {
				System.out.println("found field : " + field.get());
				String name = field.get().getName();
				System.out.println("name of field : " + name);

				if (repo != null) {
					System.out.println("repo : " + repo.toString());
					Optional<? extends Audit> entity = repo.findById(entry.getValue());
					if (entity.isPresent()) {
						System.out.println("found entity : " + entity.get());
						query.setParameter(name, entity.get());
					}
				}

			} else {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return query;
	}

	private String createPartQueryWithWhere(Map<String, String> foreignKeysMap) {
		StringBuilder queryWhere = new StringBuilder(" WHERE");
		String context = "t.";
		for (Entry<String, String> entry : foreignKeysMap.entrySet()) {
			queryWhere.append(" " + context + entry.getKey() + " = :" + entry.getKey() + " AND ");
		}
		queryWhere.delete(queryWhere.length() - 5, queryWhere.length() - 1);

		return queryWhere.toString();
	}

	@Transactional
	@Override
	public Page<E> getAllWithPaginationByForeignKeys(Map<String, String> fieldMap, Integer pageNumber,
			Integer pageSize) {

		int offset = pageSize * (pageNumber - 1);

		String queryTemplate = "Select t from " + this.typeInfoE.getParameterClassName() + " t "
				+ createPartQueryWithWhere(fieldMap);

		String queryTemplateCount = "SELECT COUNT( t ) FROM " + this.typeInfoE.getParameterClassName() + " t "
				+ createPartQueryWithWhere(fieldMap);

		TypedQuery<E> query = entityManager.createQuery(queryTemplate, this.typeInfoE.getParameterTypeClass());
		TypedQuery<Long> queryCount = entityManager.createQuery(queryTemplateCount, Long.class);

		setAllParametersQuery(query, fieldMap);
		setAllParametersQueryForCount(queryCount, fieldMap);

		List<E> entityAList = (List<E>) query.setFirstResult(offset).setMaxResults(pageSize).getResultList();

//		System.out.println("queryCount : " + queryCount.getHints());

		Long total = queryCount.getResultList().get(0);
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<E> pageEntities = new PageImpl<E>(entityAList, pageRequest, total);
//		entityManager.clear();
		return pageEntities;
	}

	@Override
	public Page<E> getAllWithPaginationAndSortingByForeignKeys(Map<String, String> fieldMap, Integer pageNumber,
			Integer pageSize, String sortField, String direction) {

		if (sortField == null || direction == null || !(direction.equals("ASC") || direction.equals("DESC")))
			return getAllWithPaginationByForeignKeys(fieldMap, pageNumber, pageSize);

		int offset = pageSize * (pageNumber - 1);

		String queryTemplate = "Select t from " + this.typeInfoE.getParameterClassName() + " t "
				+ createPartQueryWithWhere(fieldMap) + " ORDER BY" + " t." + sortField + " " + direction;

		String queryTemplateCount = "SELECT COUNT( t ) FROM " + this.typeInfoE.getParameterClassName() + " t "
				+ createPartQueryWithWhere(fieldMap);

		TypedQuery<E> query = entityManager.createQuery(queryTemplate, this.typeInfoE.getParameterTypeClass());
		TypedQuery<Long> queryCount = entityManager.createQuery(queryTemplateCount, Long.class);

		setAllParametersQuery(query, fieldMap);
		setAllParametersQueryForCount(queryCount, fieldMap);

		List<E> entityAList = (List<E>) query.setFirstResult(offset).setMaxResults(pageSize).getResultList();

//		System.out.println("queryCount : " + queryCount.getHints());

		Long total = queryCount.getResultList().get(0);

		Sort sort = direction.equals("ASC") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();// Sort.by("price").descending().and(Sort.by("name"))
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);
		Page<E> pageEntities = new PageImpl<E>(entityAList, pageRequest, total);
//		entityManager.clear();
		return pageEntities;
		// ORDER BY
	}

}
