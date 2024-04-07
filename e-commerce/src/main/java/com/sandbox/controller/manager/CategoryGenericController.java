package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.manager.CategoryDTO;
import com.sandbox.entity.manager.Category;

@RestController
@RequestMapping(path = "/managerAPI/categories")
public class CategoryGenericController extends WithOneForeignKeyController<CategoryDTO,Category> {

}