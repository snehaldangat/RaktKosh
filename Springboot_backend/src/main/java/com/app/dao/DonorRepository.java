package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Donor;

public interface DonorRepository extends JpaRepository<Donor, String>{
	
	Donor findByEmailAndPassword(String email, String password);
	
	@Query(value="select  d from Donor d where d.mobile=:mobile")
	Donor getDonorByMobile(String mobile);

}
