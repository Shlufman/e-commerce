package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.entity.manager.Collection;

@RestController
@RequestMapping(path = "/managerAPI/collections")
public class CollectionGenericController extends WithOneForeignKeyController<CollectionDTO, Collection> {

}