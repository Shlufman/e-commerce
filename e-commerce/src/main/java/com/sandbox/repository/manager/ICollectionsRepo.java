package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.repository.abstraction.IUniversalRepo;

@Repository(value = "collection")
public interface ICollectionsRepo extends JpaRepository<Collection, String>{ //ICommonRepository<Collection>

}
