package com.sandbox.util.mapper.abstraction;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

public interface IMapper<E, D> {

	List<Field> getEFields();

	List<Field> getDFields();

	List<Field> getForeignKeyFields();

	List<Field> getPrimaryKeyDFields();
	
	 Map<Field, Field> getMapEntityKeyfields();
	 Map<Field, Field> getMapDtoKeyfields();

	E requestDtoToEntity(D dto);

	D entityToResponseDto(E entity);

	List<D> entityListToResponseListDto(List<E> entities);

	Page<D> entityPageToResponsePageDto(Page<E> pageEntites);
	
//	String getParameterClassNameE();
//	String getParameterClassNameD();
//	Class<E> getParameterTypeClassE();
//	Class<D> getParameterTypeClassD();
}
