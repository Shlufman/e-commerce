package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Supplier;

@Repository(value = "supplier")
public interface ISuppliersRepo extends JpaRepository<Supplier, String>{//

}
