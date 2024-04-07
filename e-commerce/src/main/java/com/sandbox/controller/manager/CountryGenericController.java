package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.CountryDTO;

@RestController
@RequestMapping(path = "/managerAPI/countries")
public class CountryGenericController extends SimpleController<CountryDTO>{

}