package com.sandbox.util.mapper.abstraction;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sandbox.annotation.ForeignKey;

public class TypeInfo<E> implements ITypeInfo<E> {

	private Class<E> classE;
	private List<Field> aLLFields;
	private List<Field> fKFields;
	private List<Field> pKFields;

	public TypeInfo(Class<E> classE) {
		super();
		this.classE = classE;
		setField();
		this.fKFields = new ArrayList<>();
		this.pKFields = new ArrayList<>();
		setFields();
	}

	private void setFields() {
		for (Field f : this.aLLFields) {
			if (f.isAnnotationPresent(ForeignKey.class)) {
				System.out.println("classE : " + classE.getName() + " : field : " + f.getName());
				this.fKFields.add(f);
				this.pKFields.add(getPKField(f));
			}
		}
	}

	private void setField() {
		this.aLLFields = Arrays.asList(this.classE.getDeclaredFields());
	}

	private Field getPKField(Field field) {
		try {
			return field.getAnnotation(ForeignKey.class).value().getSuperclass().getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("!!!!! Field getPKField");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Field> getFields() {
		return this.aLLFields;
	}

	@Override
	public List<Field> getForeignKeyFields() {
		return this.fKFields;
	}

	@Override
	public String getParameterClassName() {
		return this.classE.getCanonicalName();
	}

	@Override
	public Class<E> getParameterTypeClass() {
		return this.classE;
	}

	@Override
	public String getCode() {
		return this.classE.getSimpleName();
	}

}
