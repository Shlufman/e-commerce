package com.sandbox.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.sandbox.dto.manager.SupplierDTO;

public class SupplierServiceImpl implements ISupplierService{

	@Override
	public Page<SupplierDTO> getSuppliersWithPaginationAndSorting(Integer offset, Integer pageSize,
			Sort sortFieldNameDirection){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<SupplierDTO> getSuppliersByIdWithPagination(Integer id, Integer offset, Integer pageSize){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<SupplierDTO> getSuppliersByNameWithPaginationAndSorting(String name, Integer offset, Integer pageSize,
			Sort sortFieldNameDirection) {
		// TODO Auto-generated method stub
		return null;
	}
}
