package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.TypeGoods;

@Repository(value = "typeGoods")
public interface ITypeGoodsRepo extends JpaRepository<TypeGoods, String>{//

}
