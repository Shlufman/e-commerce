package com.sandbox.controller.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IOneForeignKeyController<D> {
	ResponseEntity<Page<D>> getAllWithPaginationByForeignKey(Integer pageNumber, Integer pageSize,
			String sortField, String direction, String key1, String id);
}
