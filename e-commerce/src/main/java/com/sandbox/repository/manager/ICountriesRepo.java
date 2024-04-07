package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Country;

@Repository(value = "country")
public interface ICountriesRepo extends JpaRepository<Country, String>{//

}
