package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.dto.manager.ManagerDTO;
import com.sandbox.entity.manager.Manager;

@RestController
@RequestMapping(path = "/managerAPI/managers")
public class ManagerGenericController extends WithOneForeignKeyController<ManagerDTO,Manager> {

}