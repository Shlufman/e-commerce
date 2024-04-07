package com.sandbox.repository.abstraction;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

//@Repository
public interface IUniversalRepo<E>{
	Class<E> getTypeClass();

	Page<E> getAllWithPaginationByForeignKeys(Map<String,String> fieldMap, Integer pageNumber,
			Integer pageSize);
	
	Page<E> getAllWithPaginationAndSortingByForeignKeys(Map<String,String> fieldMap, Integer pageNumber,
			Integer pageSize, String sortField, String direction);
}
