package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Manager;
import com.sandbox.repository.abstraction.IUniversalRepo;

@Repository(value = "manager")
public interface IManagersRepo extends JpaRepository<Manager, String>{ //ICommonRepository<Manager>

}
