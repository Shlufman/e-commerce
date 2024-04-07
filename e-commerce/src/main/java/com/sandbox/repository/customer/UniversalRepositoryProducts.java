package com.sandbox.repository.customer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Manager;
import com.sandbox.repository.abstraction.IUniversalRepo;
import com.sandbox.repository.abstraction.UniversalRepo;

//@Repository(value = "iproduct")
//@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Component
//@Service
public class UniversalRepositoryProducts extends UniversalRepo<Product> {

	public UniversalRepositoryProducts() {
		super(Product.class);
	}

}
