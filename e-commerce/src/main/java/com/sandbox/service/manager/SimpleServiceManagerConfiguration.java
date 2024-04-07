package com.sandbox.service.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.dto.manager.CountryDTO;
import com.sandbox.dto.manager.DiscountDTO;
import com.sandbox.dto.manager.RoleDTO;
import com.sandbox.dto.manager.SeasonDTO;
import com.sandbox.dto.manager.SectionDTO;
import com.sandbox.dto.manager.StatusOrderDTO;
import com.sandbox.dto.manager.StyleDTO;
import com.sandbox.dto.manager.SupplierDTO;
import com.sandbox.dto.manager.TypeGoodsDTO;
import com.sandbox.entity.manager.Brand;
import com.sandbox.entity.manager.Color;
import com.sandbox.entity.manager.Country;
import com.sandbox.entity.manager.Discount;
import com.sandbox.entity.manager.Role;
import com.sandbox.entity.manager.Season;
import com.sandbox.entity.manager.Section;
import com.sandbox.entity.manager.StatusOrder;
import com.sandbox.entity.manager.Style;
import com.sandbox.entity.manager.Supplier;
import com.sandbox.entity.manager.TypeGoods;
import com.sandbox.service.abstraction.CommonSimpleEntityService;
import com.sandbox.service.abstraction.ICommonSimpleEntityService;

@Configuration
public class SimpleServiceManagerConfiguration {

	@Bean()
	ICommonSimpleEntityService<ColorDTO> colorGenericService() {
		return new CommonSimpleEntityService<ColorDTO, Color>(ColorDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<BrandDTO> brandGenericService() {
		return new CommonSimpleEntityService<BrandDTO, Brand>(BrandDTO.class) {
		};
	}

	@Bean()
	ICommonSimpleEntityService<CountryDTO> countryGenericService() {
		return new CommonSimpleEntityService<CountryDTO, Country>(CountryDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<DiscountDTO> discountGenericService() {
		return new CommonSimpleEntityService<DiscountDTO, Discount>(DiscountDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<RoleDTO> roleGenericService() {
		return new CommonSimpleEntityService<RoleDTO, Role>(RoleDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<SeasonDTO> seasonGenericService() {
		return new CommonSimpleEntityService<SeasonDTO, Season>(SeasonDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<SectionDTO> sectionGenericService() {
		return new CommonSimpleEntityService<SectionDTO, Section>(SectionDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<StatusOrderDTO> statusOrderGenericService() {
		return new CommonSimpleEntityService<StatusOrderDTO, StatusOrder>(StatusOrderDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<StyleDTO> styleGenericService() {
		return new CommonSimpleEntityService<StyleDTO, Style>(StyleDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<SupplierDTO> supplierGenericService() {
		return new CommonSimpleEntityService<SupplierDTO, Supplier>(SupplierDTO.class) {
		};
	}
	
	@Bean()
	ICommonSimpleEntityService<TypeGoodsDTO> typeGoodsGenericService() {
		return new CommonSimpleEntityService<TypeGoodsDTO, TypeGoods>(TypeGoodsDTO.class) {
		};
	}
}


































