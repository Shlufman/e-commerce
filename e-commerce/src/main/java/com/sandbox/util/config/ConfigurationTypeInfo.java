package com.sandbox.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.dto.manager.CategoryDTO;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.dto.manager.InvoiceDTO;
import com.sandbox.dto.manager.ManagerDTO;
import com.sandbox.dto.manager.SizeDTO;
import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Color;
import com.sandbox.entity.manager.Invoice;
import com.sandbox.entity.manager.Manager;
import com.sandbox.entity.manager.Size;
import com.sandbox.util.mapper.abstraction.CommonMapper;
import com.sandbox.util.mapper.abstraction.IMapper;
import com.sandbox.util.mapper.abstraction.ITypeInfo;
import com.sandbox.util.mapper.abstraction.TypeInfo;

@Configuration
public class ConfigurationTypeInfo {
	
	@Bean
    public ITypeInfo<Product > commonTypeInfoProduct() {
		return new TypeInfo<Product>(Product.class);
	}

	@Bean
    public ITypeInfo<ProductDTO> commonTypeInfoProductDTO() {
		return new TypeInfo<ProductDTO>(ProductDTO.class);
	}
	
	@Bean
    public ITypeInfo<Collection> commonTypeInfoCollection() {
		return new TypeInfo<Collection>(Collection.class);
	}

	@Bean
    public ITypeInfo<CollectionDTO> commonTypeInfoCollectionDTO() {
		return new TypeInfo<CollectionDTO>(CollectionDTO.class);
	}
	
	@Bean
    public ITypeInfo<Category> commonTypeInfoCategory() {
		return new TypeInfo<Category>(Category.class);
	}

	@Bean
    public ITypeInfo<CategoryDTO> commonTypeInfoCategoryDTO() {
		return new TypeInfo<CategoryDTO>(CategoryDTO.class);
	}
	
	@Bean
    public ITypeInfo<Invoice> commonTypeInfoInvoice() {
		return new TypeInfo<Invoice>(Invoice.class);
	}

	@Bean
    public ITypeInfo<InvoiceDTO> commonTypeInfoInvoiceDTO() {
		return new TypeInfo<InvoiceDTO>(InvoiceDTO.class);
	}
	
	@Bean
    public ITypeInfo<Manager> commonTypeInfoManager() {
		return new TypeInfo<Manager>(Manager.class);
	}

	@Bean
    public ITypeInfo<ManagerDTO> commonTypeInfoManagerDTO() {
		return new TypeInfo<ManagerDTO>(ManagerDTO.class);
	}
	
	@Bean
    public ITypeInfo<Size> commonTypeInfoSize() {
		return new TypeInfo<Size>(Size.class);
	}

	@Bean
    public ITypeInfo<SizeDTO> commonTypeInfoSizeDTO() {
		return new TypeInfo<SizeDTO>(SizeDTO.class);
	}
	

}
