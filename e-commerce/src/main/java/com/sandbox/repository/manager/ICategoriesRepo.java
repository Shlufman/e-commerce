package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Category;
import com.sandbox.repository.abstraction.IUniversalRepo;

@Repository(value = "category")
public interface ICategoriesRepo extends JpaRepository<Category, String>{ // UniversalRepository<Category>

}
