package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Section;

@Repository(value = "section")
public interface ISectionsRepo extends JpaRepository<Section, String>{//

}
