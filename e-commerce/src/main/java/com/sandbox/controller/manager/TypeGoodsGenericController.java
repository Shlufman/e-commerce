package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.TypeGoodsDTO;

@RestController
@RequestMapping(path = "/managerAPI/type_goods")
public class TypeGoodsGenericController extends SimpleController<TypeGoodsDTO>{

}