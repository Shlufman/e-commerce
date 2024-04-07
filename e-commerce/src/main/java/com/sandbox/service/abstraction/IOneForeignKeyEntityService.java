package com.sandbox.service.abstraction;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IOneForeignKeyEntityService<D> {

	D add(D dto);

	D getById(String id);

	List<D> getAll();

	D update(D dto);

	void deleteById(String id);

	Page<D> getAllWithPagination(int pageNumber, int pageSize);

	Page<D> getAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortField, String direction);

}
