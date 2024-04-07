package com.sandbox.repository.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Category;
import com.sandbox.repository.abstraction.IUniversalRepo;
import com.sandbox.repository.abstraction.UniversalRepo;
import com.sandbox.repository.customer.UniversalRepositoryProducts;

//@Configuration
public class UniversalRepositoryConfiguration {
	
//	@Bean
//	public UniversalRepo<Category> universalRepositoryCategories(){
//		return new UniversalRepo<Category>(Category.class);
//	}

}
