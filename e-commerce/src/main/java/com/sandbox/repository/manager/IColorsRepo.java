package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.manager.Color;

@Repository(value = "color")
public interface IColorsRepo extends JpaRepository<Color, String>{

//	@Modifying
//	@Transactional
//	@Query(value = "update testnewschema.colors set color_name = :name, rgb_code = :rgb, modify_date = CURRENT_TIMESTAMP where color_id = :id", nativeQuery = true) //localtimestamp
//	void updateColor(@Param(value = "id") String colorId, @Param(value = "name") String name, @Param(value = "rgb") String rgb);

}
