package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Season;

@Repository(value = "season")
public interface ISeasonsRepo extends JpaRepository<Season, String>{//

}
