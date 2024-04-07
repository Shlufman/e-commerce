package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Discount;


@Repository(value = "discount")
public interface IDiscountsRepo extends JpaRepository<Discount, String>{//

}
