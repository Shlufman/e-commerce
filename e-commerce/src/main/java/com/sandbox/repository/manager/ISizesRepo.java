package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Size;
import com.sandbox.repository.abstraction.IUniversalRepo;

@Repository(value = "size")
public interface ISizesRepo extends JpaRepository<Size, String>{ //ICommonRepository<Size>

}
