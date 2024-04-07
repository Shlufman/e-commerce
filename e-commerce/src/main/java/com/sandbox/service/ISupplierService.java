package com.sandbox.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.sandbox.dto.manager.SupplierDTO;

public interface ISupplierService {

	Page<SupplierDTO> getSuppliersWithPaginationAndSorting(Integer offset, Integer pageSize,
			Sort sortFieldNameDirection);

	Page<SupplierDTO> getSuppliersByIdWithPagination(Integer id, Integer offset, Integer pageSize);
	
	Page<SupplierDTO> getSuppliersByNameWithPaginationAndSorting(String name, Integer offset, Integer pageSize,
			Sort sortFieldNameDirection);

}
