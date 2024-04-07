package com.sandbox.util.mapper.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.sandbox.entity.abstraction.Audit;

import java.lang.reflect.Field;
import java.lang.Object;

public class MapperWithOneForeignKey<E, D> implements IMapper<E, D> {

	private String ENTITY_TYPE;
	private String DTO_TYPE;
	private List<Field> entityFields = new ArrayList<>();
	private List<Field> dtoFields = new ArrayList<>();
	private Field idField;
	
	public MapperWithOneForeignKey(Class<E> classEntity, Class<D> classD) {

		this.ENTITY_TYPE = classEntity.getName();
		this.DTO_TYPE = classD.getCanonicalName();
		this.idField = getFieldID(classEntity);
		Map<String, Field> entityFieldsMap = Arrays.stream(classEntity.getDeclaredFields())
				.collect(Collectors.toMap(f -> f.getName(), f -> f));

		entityFieldsMap.put("id", idField);
//		System.out.println(entityFieldsMap);
		this.dtoFields = new ArrayList<Field>(Arrays.asList(classD.getDeclaredFields()));
		
		this.entityFields = filter(entityFieldsMap);
	}
	
	@Override
	public Map<Field, Field> getMapEntityKeyfields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Field, Field> getMapDtoKeyfields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Field> getEFields() {
		return this.entityFields;
	}
	
	@Override
	public List<Field> getDFields() {
		return this.dtoFields;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E requestDtoToEntity(D dto) {
		Object entity = null;
		try {
			entity = Class.forName(ENTITY_TYPE).getDeclaredConstructor().newInstance();
			if (entity != null) {
				Field entityField = null;
				Field dtoField = null;
				for (int index = 0; index < dtoFields.size(); index++) {
					dtoField = dtoFields.get(index);
					if (dtoField != null) {
						dtoField.setAccessible(true);
						entityField = entityFields.get(index);
					}
					if (entityField != null) {
						entityField.setAccessible(true);
						entityField.set(entity, dtoField.get(dto));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		return (E) entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public D entityToResponseDto(E entity) {
		Object dto = null;
		try {
			dto = Class.forName(DTO_TYPE).getDeclaredConstructor().newInstance();
			if (dto != null) {
				Field entityField;
				Field dtoField;
				for (int index = 0; index < dtoFields.size(); index++) {
					dtoField = dtoFields.get(index);
					dtoField.setAccessible(true);
					entityField = entityFields.get(index);
					entityField.setAccessible(true);
					dtoField.set(dto, entityField.get(entity));
				}
			}
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		return (D) dto;
	}

	@Override
	public List<D> entityListToResponseListDto(List<E> entities) {
		List<D> dtos = new ArrayList<>();
		if (entities.isEmpty())
			return dtos;

		for (E entity : entities) {
			dtos.add(entityToResponseDto(entity));
		}
		return dtos;
	}

	@Override
	public Page<D> entityPageToResponsePageDto(Page<E> pageEntites) {

		Page<D> PageDtos;
		if (pageEntites.isEmpty()) {
			PageDtos = new PageImpl<D>(new ArrayList<D>());
		} else {
			PageDtos = pageEntites.map(entity -> entityToResponseDto(entity));
		}

		return PageDtos;
	}
	
	private List<Field> filter(Map<String, Field> entityFieldsMap) {
		List<Field> entityFieldsFiltred = new ArrayList<Field>();
		for (Field dtoField : dtoFields) {
			entityFieldsFiltred.add(entityFieldsMap.get(dtoField.getName()));
		}
		return entityFieldsFiltred;
	}

	@SuppressWarnings("unchecked")
	private Field getFieldID(Class<E> classEntity) {
		Class<Audit> audit =(Class<Audit>) classEntity.getSuperclass();
		Field fielaId =null;
		try {
			fielaId= audit.getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fielaId;
	}

	@Override
	public List<Field> getForeignKeyFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Field> getPrimaryKeyDFields() {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Override
//	public String getParameterClassNameE() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getParameterClassNameD() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Class<E> getParameterTypeClassE() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Class<D> getParameterTypeClassD() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}

//for (Field field : dtoFields) {
//field.setAccessible(true);
//Field fieldEntity = entity.getClass().getDeclaredField(field.getName());
//fieldEntity.setAccessible(true);
//fieldEntity.set(entity, field.get(dto));
//}

//for (Field field : dtoFields) {
//field.setAccessible(true);
//Field fieldE = entity.getClass().getDeclaredField(field.getName());
//fieldE.setAccessible(true);
//field.set(dto, fieldE.get(entity));
//}
