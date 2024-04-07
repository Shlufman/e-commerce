package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.SectionDTO;

@RestController
@RequestMapping(path = "/managerAPI/sections")
public class SectionGenericController extends SimpleController<SectionDTO>{

}