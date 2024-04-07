package com.sandbox.controller.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.entity.customer.Product;

@RestController
@RequestMapping(path = "/customerAPI/products")
public class ProductGenericController extends WithOneForeignKeyController<ProductDTO,Product> {

}