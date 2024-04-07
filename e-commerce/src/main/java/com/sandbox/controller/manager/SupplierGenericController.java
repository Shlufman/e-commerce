package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.SupplierDTO;

@RestController
@RequestMapping(path = "/managerAPI/suppliers")
public class SupplierGenericController extends SimpleController<SupplierDTO>{

}