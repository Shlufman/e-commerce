package com.sandbox.service.abstraction;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.constants.IConstantsAPI;
import com.sandbox.entity.abstraction.Audit;
import com.sandbox.entity.abstraction.EntityFactory;
import com.sandbox.repository.abstraction.IUniversalRepo;
import com.sandbox.util.mapper.abstraction.IMapper;
import com.sandbox.util.mapper.abstraction.ITypeInfo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

public class CommonNotSimpleEntityService<D, E> implements IWithForeignKeysService<D> {

	@Autowired
	private Validator validator;

	@Autowired
	IMapper<E, D> mapper;

	@Autowired
	ITypeInfo<E> typeInfoE;

	@Autowired
	ITypeInfo<D> typeInfoD;

	@Autowired
	JpaRepository<E, String> repository;

	@Autowired
	EntityFactory entityFactory;

	IUniversalRepo<E> universalRepository;

	@Autowired
	private Map<String, JpaRepository<? extends Audit, String>> repositories;

	private List<Field> dtoFields;
	private List<Field> entityFields;
	private Field idField;
	private Map<Field, Field> dtoKeyfields;

	private Class<E> classEntity;

	public CommonNotSimpleEntityService(Class<D> classDto, Class<E> classEntity) {
		super();
		this.classEntity = classEntity;
		try {
			this.idField = classDto.getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Page<D> getAllWithPaginationByForeignKeys(Map<String, String> fieldMap, Integer pageNumber,
			Integer pageSize) {

		validationFiltersFields(fieldMap);

		Page<E> entities = universalRepository.getAllWithPaginationByForeignKeys(fieldMap, pageNumber, pageSize);
		return mapper.entityPageToResponsePageDto(entities);
	}

	private void validationFiltersFields(Map<String, String> fieldMap) {
		// TODO Auto-generated method stub

	}

	@PostConstruct
	public void init() {
		this.dtoFields = mapper.getDFields();
		this.entityFields = mapper.getEFields();
		this.dtoKeyfields = mapper.getMapDtoKeyfields();

		this.universalRepository = this.entityFactory.getRepository(classEntity);
	}

	@Override
	public Page<D> getAllWithPaginationSortedByForeignKeys(Map<String, String> fieldMap, Integer pageNumber,
			Integer pageSize, String sortField, String direction) {

		validationFiltersFields(fieldMap);

		Page<E> entities = universalRepository.getAllWithPaginationAndSortingByForeignKeys(fieldMap, pageNumber,
				pageSize, sortField, direction);
		return mapper.entityPageToResponsePageDto(entities);
	}

	@Transactional
	@Override
	public D add(D dto) {
		validation(dto);

		E entity = mapper.requestDtoToEntity(dto);

		for (Entry<Field, Field> entry : dtoKeyfields.entrySet()) {
			Field fieldDto = entry.getKey();
			String id = getID(fieldDto, dto);

			String keyBean = fieldDto.getName();
			keyBean = keyBean.substring(0, keyBean.length() - 2);

			Object entityByForeignKey = repositories.get(keyBean).findById(id).orElseThrow(() -> {
				throw new EntityNotFoundException(IConstantsAPI.ENTITY_NOT_FOUND);
			});
			try {
				Field fieldEntity = this.classEntity.getDeclaredField(keyBean);
				fieldEntity.setAccessible(true);
				setter(fieldEntity, entity, entityByForeignKey);
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		entity = repository.save(entity);
		return mapper.entityToResponseDto(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public D getById(String id) {
		Optional<E> tOptional = repository.findById(id);

		if (tOptional.isEmpty())
			throw new EntityNotFoundException(IConstantsAPI.ENTITY_NOT_FOUND);

		return mapper.entityToResponseDto(tOptional.get());
	}

	@Transactional(readOnly = true)
	@Override
	public List<D> getAll() {
		List<E> entities = repository.findAll();

		List<D> dtos = mapper.entityListToResponseListDto(entities);

		return dtos;
	}

	@Transactional
	@Override
	public D update(D dto) {
		validation(dto);

		E updateEntity = repository.findById(getID(this.idField, dto)).orElseThrow(() -> {
			throw new EntityNotFoundException(IConstantsAPI.ENTITY_NOT_FOUND);
		});
		Field dtoField = null;
		Field entityField = null;
		for (int index = 0; index < this.dtoFields.size(); index++) {
			dtoField = dtoFields.get(index);
			dtoField.setAccessible(true);
			entityField = entityFields.get(index);
			entityField.setAccessible(true);
			setter(entityField, dtoField, updateEntity, dto);
		}
		return mapper.entityToResponseDto(updateEntity);
	}

	@Transactional
	@Override
	public void deleteById(String id) {
		Optional<E> tOptional = repository.findById(id);
		if (tOptional.isEmpty())
			throw new EntityNotFoundException(IConstantsAPI.ENTITY_NOT_FOUND);
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<D> getAllWithPagination(int pageNumber, int pageSize) {
		Page<E> entitiesPage = repository.findAll(PageRequest.of(pageNumber, pageSize));

		return mapper.entityPageToResponsePageDto(entitiesPage);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<D> getAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortField, String direction) {
		if (!isValidSortField(sortField))
			return getAllWithPagination(pageNumber, pageSize);

		Direction sortDirection = direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
		Page<E> entitiesPage = repository
				.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));

		return mapper.entityPageToResponsePageDto(entitiesPage);
	}

	private boolean isValidSortField(String sortField) {
		throw new NotImplementedException("Not implemented method isValidSortField in CommonSimpleEntityService");
//		return Arrays.stream(SortFields.colorSortFields).anyMatch(s -> s.equals(sortField));
	}

	private void validation(D dto) {
		Set<ConstraintViolation<D>> violations = validator.validate(dto);

		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<D> constraintViolation : violations) {
				sb.append(constraintViolation.getMessage());
			}
//			if (entity.getId() == null || entity.getId().isBlank()) {
//			// ToDo
			throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
//			Collection entity = repository.findById(dto.getId())
//			.orElseThrow(() -> new EntityNotFoundException(IConstantsAPI.ENTITY_NOT_FOUND));

		}
	}

	private String getID(Field idField, Object source) {
		String result = null;
		idField.setAccessible(true);
		try {
			result = (String) idField.get(source);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private void setter(Field recipientField, Object recipient, Object value) {
		try {
			recipientField.set(recipient, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setter(Field recipientField, Field sourceField, Object recipient, Object source) {
		try {
			recipientField.set(recipient, sourceField.get(source));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
