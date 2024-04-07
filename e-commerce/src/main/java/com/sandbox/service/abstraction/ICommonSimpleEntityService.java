package com.sandbox.service.abstraction;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sandbox.entity.abstraction.Audit;

@Service
public interface ICommonSimpleEntityService<D>{ // extends Audit

	D add(D entity);

	D getById(String id);

	List<D> getAll();

	D update(D entity);

	void deleteById(String id);

	Page<D> getAllWithPagination(int pageNumber, int pageSize);

	Page<D> getAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortField, String direction);

}
