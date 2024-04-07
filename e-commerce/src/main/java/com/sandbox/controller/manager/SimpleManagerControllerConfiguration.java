package com.sandbox.controller.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.ISimpleController;
import com.sandbox.controller.generic.SimpleController;
import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.dto.manager.CountryDTO;

@Configuration
public class SimpleManagerControllerConfiguration {

//	@Bean()
//	ISimpleController<BrandDTO> brandGenericController() {
//
//		@RestController
//		@RequestMapping(path = "/managerAPI/brands")
//		class BrandGenericController extends SimpleController<BrandDTO> {
//		}
//
//		return new BrandGenericController();
//	}
//	
//	@Bean()
//	ISimpleController<ColorDTO> colorGenericController() {
//
//		@RestController
//		@RequestMapping(path = "/managerAPI/colors")
//		class ColorGenericController extends SimpleController<ColorDTO> {
//
//		}
//
//		return new ColorGenericController();
//	}
//	
//	@Bean()
//	ISimpleController<CountryDTO> countryGenericController() {
//
//		@RestController
//		@RequestMapping(path = "/managerAPI/countries")
//		class CountryGenericController extends SimpleController<CountryDTO>{
//
//		}
//
//		return new CountryGenericController();
//	}
	
}
