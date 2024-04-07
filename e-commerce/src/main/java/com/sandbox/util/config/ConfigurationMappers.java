package com.sandbox.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.dto.manager.CategoryDTO;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.dto.manager.CountryDTO;
import com.sandbox.dto.manager.DiscountDTO;
import com.sandbox.dto.manager.InvoiceDTO;
import com.sandbox.dto.manager.ManagerDTO;
import com.sandbox.dto.manager.RoleDTO;
import com.sandbox.dto.manager.SeasonDTO;
import com.sandbox.dto.manager.SectionDTO;
import com.sandbox.dto.manager.SizeDTO;
import com.sandbox.dto.manager.StatusOrderDTO;
import com.sandbox.dto.manager.StyleDTO;
import com.sandbox.dto.manager.SupplierDTO;
import com.sandbox.dto.manager.TypeGoodsDTO;
import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Brand;
import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Color;
import com.sandbox.entity.manager.Country;
import com.sandbox.entity.manager.Discount;
import com.sandbox.entity.manager.Invoice;
import com.sandbox.entity.manager.Manager;
import com.sandbox.entity.manager.Role;
import com.sandbox.entity.manager.Season;
import com.sandbox.entity.manager.Section;
import com.sandbox.entity.manager.Size;
import com.sandbox.entity.manager.StatusOrder;
import com.sandbox.entity.manager.Style;
import com.sandbox.entity.manager.Supplier;
import com.sandbox.entity.manager.TypeGoods;
import com.sandbox.util.mapper.abstraction.CommonMapper;
import com.sandbox.util.mapper.abstraction.IMapper;

@Configuration
public class ConfigurationMappers {

	@Bean
    public IMapper<Color,ColorDTO> commonMapperColor() {
		return new CommonMapper<Color,ColorDTO>(Color.class,ColorDTO.class);
	}
	
	@Bean
    public IMapper<Brand,BrandDTO> commonMapperBrand() {
		return new CommonMapper<Brand,BrandDTO>(Brand.class,BrandDTO.class);
	}
	
	@Bean
    public IMapper<Style,StyleDTO> commonMapperStyle() {
		return new CommonMapper<Style,StyleDTO>(Style.class,StyleDTO.class);
	}
	
	@Bean
    public IMapper<Season,SeasonDTO> commonMapperSeason() {
		return new CommonMapper<Season,SeasonDTO>(Season.class,SeasonDTO.class);
	}
	
	@Bean
    public IMapper<Section,SectionDTO> commonMapperSection() {
		return new CommonMapper<Section,SectionDTO>(Section.class,SectionDTO.class);
	}
	
	@Bean
    public IMapper<Supplier,SupplierDTO> commonMapperSupplier() {
		return new CommonMapper<Supplier,SupplierDTO>(Supplier.class,SupplierDTO.class);
	}
	
	@Bean
    public IMapper<TypeGoods,TypeGoodsDTO> commonMapperTypeGoods() {
		return new CommonMapper<TypeGoods,TypeGoodsDTO>(TypeGoods.class,TypeGoodsDTO.class);
	}
	
	@Bean
    public IMapper<StatusOrder,StatusOrderDTO> commonMapperStatusOrder() {
		return new CommonMapper<StatusOrder,StatusOrderDTO>(StatusOrder.class,StatusOrderDTO.class);
	}
		
	@Bean
    public IMapper<Country,CountryDTO> commonMapperCountry() {
		return new CommonMapper<Country,CountryDTO>(Country.class,CountryDTO.class);
	}
	
	@Bean
    public IMapper<Role,RoleDTO> commonMapperRole() {
		return new CommonMapper<Role,RoleDTO>(Role.class,RoleDTO.class);
	}
	
	@Bean
    public IMapper<Discount,DiscountDTO> commonMapperDiscount() {
		return new CommonMapper<Discount,DiscountDTO>(Discount.class,DiscountDTO.class);
	}
	
	@Bean
    public IMapper<Collection,CollectionDTO> commonMapperCollection() {
		return new CommonMapper<Collection,CollectionDTO>(Collection.class,CollectionDTO.class);
	}
	
	@Bean
    public IMapper<Category,CategoryDTO> commonMapperCategory() {
		return new CommonMapper<Category,CategoryDTO>(Category.class,CategoryDTO.class);
	}
	
	@Bean
    public IMapper<Manager,ManagerDTO> commonMapperManager() {
		return new CommonMapper<Manager,ManagerDTO>(Manager.class,ManagerDTO.class);
	}
	
	@Bean
    public IMapper<Invoice,InvoiceDTO> commonMapperInvoice() {
		return new CommonMapper<Invoice,InvoiceDTO>(Invoice.class,InvoiceDTO.class);
	}
	
	@Bean
    public IMapper<Size,SizeDTO> commonMapperSize() {
		return new CommonMapper<Size,SizeDTO>(Size.class,SizeDTO.class);
	}
	
	@Bean
    public IMapper<Product,ProductDTO> commonMapperProduct() {
		return new CommonMapper<Product,ProductDTO>(Product.class,ProductDTO.class);
	}
	
	
	
}
