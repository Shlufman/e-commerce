package com.sandbox.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Brand;

@Repository(value = "product")
public interface IProductsRepo extends JpaRepository<Product, String>{//

}
