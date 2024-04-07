package com.sandbox.util.mapper.abstraction;

import java.lang.reflect.Field;
import java.util.List;

public interface ITypeInfo<E> {
	List<Field> getFields();
	List<Field> getForeignKeyFields();
	String getParameterClassName();	
	Class<E> getParameterTypeClass();
	String getCode();
}
