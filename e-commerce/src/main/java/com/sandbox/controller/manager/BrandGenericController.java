package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.logging.Profiling;

@RestController
@RequestMapping(path = "/managerAPI/brands")
public class BrandGenericController extends SimpleController<BrandDTO>{

}