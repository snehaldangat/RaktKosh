package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.BloodBank;
import com.app.pojos.Donor;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByEmailAndPassword(String email, String password);
	
	@Query(value="select  u from User u where u.email=:email")
	User featchById(String email);
	

}
