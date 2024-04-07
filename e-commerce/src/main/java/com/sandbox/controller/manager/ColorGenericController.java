package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.ColorDTO;

@RestController
@RequestMapping(path = "/managerAPI/colors")
public class ColorGenericController extends SimpleController<ColorDTO> {

}