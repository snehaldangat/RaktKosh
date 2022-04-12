package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.City;
import com.app.pojos.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{

	@Query(value="select  d from District d where d.state.id=:id")
	List<District> getAllDistrictsByStateId(@Param("id") int stateId);
}
