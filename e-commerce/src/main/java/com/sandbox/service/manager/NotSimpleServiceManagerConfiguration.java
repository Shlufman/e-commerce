package com.sandbox.service.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.dto.manager.CategoryDTO;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.dto.manager.InvoiceDTO;
import com.sandbox.dto.manager.ManagerDTO;
import com.sandbox.dto.manager.SizeDTO;
import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Invoice;
import com.sandbox.entity.manager.Manager;
import com.sandbox.entity.manager.Size;
import com.sandbox.service.abstraction.CommonNotSimpleEntityService;
import com.sandbox.service.abstraction.IWithForeignKeysService;

@Configuration
public class NotSimpleServiceManagerConfiguration {

	@Bean()
	IWithForeignKeysService<CategoryDTO> categoryGenericService() {
		return new CommonNotSimpleEntityService<CategoryDTO,Category>(CategoryDTO.class ,Category.class) {
		};
	}
	
	@Bean()
	IWithForeignKeysService<CollectionDTO> collectionGenericService() {
		return new CommonNotSimpleEntityService<CollectionDTO,Collection>(CollectionDTO.class ,Collection.class) {
		};
	}
	
	@Bean()
	IWithForeignKeysService<InvoiceDTO> invoiceGenericService() {
		return new CommonNotSimpleEntityService<InvoiceDTO,Invoice>(InvoiceDTO.class ,Invoice.class) {
		};
	}
	
	@Bean()
	IWithForeignKeysService<ManagerDTO> managerGenericService() {
		return new CommonNotSimpleEntityService<ManagerDTO,Manager>(ManagerDTO.class ,Manager.class) {
		};
	}
	
	@Bean()
	IWithForeignKeysService<SizeDTO> sizeGenericService() {
		return new CommonNotSimpleEntityService<SizeDTO,Size>(SizeDTO.class ,Size.class) {
		};
	}
	
}
