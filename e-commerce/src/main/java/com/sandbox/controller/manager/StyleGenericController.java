package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.StyleDTO;

@RestController
@RequestMapping(path = "/managerAPI/styles")
public class StyleGenericController extends SimpleController<StyleDTO>{

}