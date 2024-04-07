package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.dto.manager.DiscountDTO;

@RestController
@RequestMapping(path = "/managerAPI/discounts")
public class DiscountGenericController extends SimpleController<DiscountDTO>{

}