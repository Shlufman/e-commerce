package com.sandbox.util.mapper.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.abstraction.Audit;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.Object;

public class CommonMapper<E, D> implements IMapper<E, D> {

	private String ENTITY_TYPE;
	private String DTO_TYPE;
	private List<Field> entityFields = new ArrayList<>();
	private List<Field> dtoFields = new ArrayList<>();
	private Field idField;
	private List<Field> foreignKeys = new ArrayList<>();
	private List<Field> primaryKeys = new ArrayList<>();
	private Map<Field, Field> entityKeyfields = new HashMap<>();
	private Map<Field, Field> dtoKeyfields = new HashMap<>();

	public CommonMapper(Class<E> classEntity, Class<D> classD) {

		this.ENTITY_TYPE = classEntity.getName();
		this.DTO_TYPE = classD.getCanonicalName();
		this.idField = getFieldID(classEntity);
		Map<String, Field> entityFieldsMap = Arrays.stream(classEntity.getDeclaredFields())
				.collect(Collectors.toMap(f -> f.getName(), f -> f));

		entityFieldsMap.put("id", idField);
		
		setFields(classEntity, classD);
		this.entityFields = filter(entityFieldsMap);
	}

	private void setFields(Class<E> classEntity, Class<D> classD) {
		Field[] dfields = classD.getDeclaredFields();
		for (Field f : dfields) {
			if (f.isAnnotationPresent(ForeignKey.class)) {
				foreignKeys.add(f);
				try {
					primaryKeys.add(f.getAnnotation(ForeignKey.class).value().getSuperclass().getDeclaredField("id"));
				} catch (NoSuchFieldException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					String nameField = f.getName();
					nameField = nameField.substring(0, nameField.length() - 2);
					Field eField = classEntity.getDeclaredField(nameField); 
					eField.setAccessible(true);
					f.setAccessible(true);
					dtoKeyfields.put(f, eField);
					entityKeyfields.put(eField, f);
				} catch (NoSuchFieldException | SecurityException e) {
					// TODO Auto-generated catch block
//					System.out.println("!!!");
					e.printStackTrace();
				}
			} else {
				dtoFields.add(f);
			}
		}
	}

	@Override
	public Map<Field, Field> getMapEntityKeyfields() {
		return this.entityKeyfields;
	}

	@Override
	public Map<Field, Field> getMapDtoKeyfields() {
		return this.dtoKeyfields;
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
	public List<Field> getForeignKeyFields() {
		return this.foreignKeys;
	}

	@Override
	public List<Field> getPrimaryKeyDFields() {
		return this.primaryKeys;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E requestDtoToEntity(D dto) {
		Object entity = null;
		entity = createNewObject(ENTITY_TYPE);

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
					setter(entityField, dtoField, entity, dto);
				}
			}
		}

		return (E) entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public D entityToResponseDto(E entity) {
		Object dto = null;
		dto = createNewObject(DTO_TYPE);
		if (dto != null) {
			Field entityField;
			Field dtoField;
			for (int index = 0; index < dtoFields.size(); index++) {
				dtoField = dtoFields.get(index);
				dtoField.setAccessible(true);
				entityField = entityFields.get(index);
				entityField.setAccessible(true);
				setter(dtoField,entityField, dto , entity);
			}
			for (Entry<Field, Field> entry : dtoKeyfields.entrySet()) {
				dtoField = entry.getKey();
				dtoField.setAccessible(true);
				entityField = entry.getValue();
				try {
					dtoField.set(dto, ((Audit) entityField.get(entity)).getId());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

	@SuppressWarnings("unchecked")
	private Field getFieldID(Class<E> classEntity) {
		Class<Audit> audit = (Class<Audit>) classEntity.getSuperclass();
		Field fielaId = null;
		try {
			fielaId = audit.getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fielaId;
	}

	private List<Field> filter(Map<String, Field> entityFieldsMap) {
		List<Field> entityFieldsFiltred = new ArrayList<Field>();
		for (Field dtoField : dtoFields) {
			entityFieldsFiltred.add(entityFieldsMap.get(dtoField.getName()));
		}
		return entityFieldsFiltred;
	}

	private Object createNewObject(String className) {
		Object result = null;
		try {
			result = Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
