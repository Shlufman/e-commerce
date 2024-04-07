package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.StatusOrderDTO;

@RestController
@RequestMapping(path = "/managerAPI/status_orders")
public class StatusOrderGenericController extends SimpleController<StatusOrderDTO>{

}