package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.manager.SizeDTO;
import com.sandbox.entity.manager.Size;

@RestController
@RequestMapping(path = "/managerAPI/sizes")
public class SizeGenericController extends WithOneForeignKeyController<SizeDTO,Size> {

}