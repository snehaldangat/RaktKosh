package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	@Query(value="select  c from City c where c.district.id=:id")
	List<City> getAllCitiesByDistrictId(@Param("id") int districtId);

}
