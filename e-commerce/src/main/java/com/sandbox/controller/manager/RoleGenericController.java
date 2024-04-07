package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.RoleDTO;

@RestController
@RequestMapping(path = "/managerAPI/roles")
public class RoleGenericController extends SimpleController<RoleDTO>{

}