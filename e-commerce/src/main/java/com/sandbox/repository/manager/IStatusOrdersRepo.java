package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.StatusOrder;

@Repository(value = "statusOrder")
public interface IStatusOrdersRepo extends JpaRepository<StatusOrder, String>{//

}
