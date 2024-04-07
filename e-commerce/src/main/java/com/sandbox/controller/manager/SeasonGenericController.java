package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.SeasonDTO;

@RestController
@RequestMapping(path = "/managerAPI/seasons")
public class SeasonGenericController extends SimpleController<SeasonDTO>{

}