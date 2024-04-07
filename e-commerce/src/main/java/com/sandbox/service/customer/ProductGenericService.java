package com.sandbox.service.customer;

import org.springframework.stereotype.Service;

import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.entity.customer.Product;
import com.sandbox.service.abstraction.CommonNotSimpleEntityService;

@Service(value = "productService")
public class ProductGenericService extends CommonNotSimpleEntityService<ProductDTO,Product> {

	public ProductGenericService() {
		super(ProductDTO.class ,Product.class);
	}


}