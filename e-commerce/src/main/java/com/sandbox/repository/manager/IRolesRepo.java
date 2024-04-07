package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Role;


@Repository(value = "role")
public interface IRolesRepo extends JpaRepository<Role, String>{//

}
