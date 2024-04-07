package com.sandbox.controller.abstraction;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


public interface ISimpleController<D> {

	void delete(String id);

	ResponseEntity<D> update(D dto);

	ResponseEntity<D> add(D dto);

	ResponseEntity<D> get(String id);

	ResponseEntity<List<D>> getAll();

	ResponseEntity<Page<D>> getAllWithPagination(Integer pageNumber, Integer pageSize, String sortField,
			String direction);
}
