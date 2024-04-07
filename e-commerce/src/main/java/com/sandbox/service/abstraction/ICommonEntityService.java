package com.sandbox.service.abstraction;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.sandbox.entity.abstraction.Audit;

public interface ICommonEntityService<D>{ // extends Audit

	Page<D> getAllWithPaginationByForeignKeys(Map<String, String> fieldMap, Integer pageNumber, Integer pageSize);

	Page<D> getAllWithPaginationSortedByForeignKeys(Map<String, String> fieldMap, Integer pageNumber,
			Integer pageSize, String sortField, String direction);
}
