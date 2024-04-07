package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Brand;

@Repository(value = "brand")
public interface IBrandsRepo extends JpaRepository<Brand, String>{//

}
