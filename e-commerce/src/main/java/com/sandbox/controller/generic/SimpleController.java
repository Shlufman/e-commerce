package com.sandbox.controller.generic;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sandbox.controller.abstraction.ISimpleController;
import com.sandbox.controller.error.ErrorDTO;
import com.sandbox.logging.Profiling;
import com.sandbox.service.abstraction.ICommonSimpleEntityService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

public class SimpleController<D> implements ISimpleController<D> {

	@Autowired
	ICommonSimpleEntityService<D> service;

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
	public ResponseEntity<D> add(@Valid @RequestBody D dto) {//

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
	
	@ExceptionHandler({ ConstraintViolationException.class ,MethodArgumentNotValidException.class})
	public ResponseEntity<?> handleException(Exception e) {
		ErrorDTO error = ErrorDTO.builder().status(HttpStatus.BAD_REQUEST).error(e.getMessage()).date(LocalDate.now())
				.build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
