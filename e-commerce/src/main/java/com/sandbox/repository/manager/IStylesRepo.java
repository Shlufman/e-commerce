package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Style;


@Repository(value = "style")
public interface IStylesRepo extends JpaRepository<Style, String>{//

}
