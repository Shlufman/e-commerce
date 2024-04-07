package com.sandbox.controller.abstraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sandbox.service.abstraction.CommonNotSimpleEntityService;
import com.sandbox.service.abstraction.ICommonSimpleEntityService;
import com.sandbox.service.abstraction.IOneForeignKeyEntityService;
import com.sandbox.service.abstraction.IWithForeignKeysService;

import jakarta.validation.Valid;

public class WithOneForeignKeyController<D, E> implements IWithOneForeignKeyController<D> {

	@Autowired
	IWithForeignKeysService<D> service;
//	CommonNotSimpleEntityService<D, E> service;
//	ICommonSimpleEntityService<D> service;
//	IOneForeignKeyEntityService<D> service;

	@Override
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public void delete(@PathVariable(name = "id", required = true) String id) {
		service.deleteById(id);
	}

	@Override
	@PutMapping(path = "")
	public ResponseEntity<D> update(@Valid @RequestBody D dto) {

		dto = service.update(dto);
		return new ResponseEntity<D>(dto, HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "")
	public ResponseEntity<D> add(@Valid @RequestBody D dto) {

		dto = service.add(dto);
		return new ResponseEntity<D>(dto, HttpStatus.OK);
	}

	@Override
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<D> get(@PathVariable(name = "id", required = true) String id) {
		D dto = service.getById(id);

		return new ResponseEntity<D>(dto, HttpStatus.OK);
	}

	@Override
	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<List<D>> getAll() {
		List<D> dtos = service.getAll();

		return new ResponseEntity<List<D>>(dtos, HttpStatus.OK);
	}

	@Override
	@GetMapping(path = { "/page-number/{pageNumber}/page-size/{pageSize}/sort/{sortField}/direction/{direction}",
			"/page-number/{pageNumber}/page-size/{pageSize}" }, produces = "application/json")
	public ResponseEntity<Page<D>> getAllWithPagination(
			@PathVariable(name = "pageNumber", required = true) Integer pageNumber,
			@PathVariable(name = "pageSize", required = true) Integer pageSize,
			@PathVariable(name = "sortField", required = false) String sortField,
			@PathVariable(name = "direction", required = false) String direction) {
		Page<D> dtosPage = (sortField == null) ? service.getAllWithPagination(pageNumber, pageSize)
				: service.getAllWithPaginationAndSorting(pageNumber, pageSize, sortField, direction);

		return new ResponseEntity<Page<D>>(dtosPage, HttpStatus.OK);
	}

	@Override
	@GetMapping(path = {
			"/{foreignKey}/{id}/page-number/{pageNumber}/page-size/{pageSize}/sort/{sortField}/direction/{direction}",
			"/{foreignKey}/{id}/page-number/{pageNumber}/page-size/{pageSize}" }, produces = "application/json")
	public ResponseEntity<Page<D>> getAllWithPaginationByForeignKey(
			@PathVariable(name = "pageNumber", required = true) Integer pageNumber,
			@PathVariable(name = "pageSize", required = true) Integer pageSize,
			@PathVariable(name = "sortField", required = false) String sortField,
			@PathVariable(name = "direction", required = false) String direction,
			@PathVariable(name = "foreignKey", required = true) String foreignKey,
			@PathVariable(name = "id", required = true) String id) {
		System.out.println(id);
		System.out.println(foreignKey);
		Map<String, String> mapFields = new HashMap<>();
		mapFields.put(foreignKey, id);
		Page<D> dtosPage = (sortField == null)
				? service.getAllWithPaginationByForeignKeys(mapFields, pageNumber, pageSize)
				: service.getAllWithPaginationSortedByForeignKeys(mapFields, pageNumber, pageSize, sortField,
						direction);

		return new ResponseEntity<Page<D>>(dtosPage, HttpStatus.OK);
	}

}
