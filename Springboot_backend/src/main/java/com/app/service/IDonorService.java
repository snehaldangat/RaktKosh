package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Donor;

public interface IDonorService {

	Donor addDonor(Donor donor);

	List<Donor> getAllDonors();

	Optional<Donor> getDonorByEmailId(String email);
	
	Donor donorLogin(String email, String password);
	
	Donor getDonorByMobile(String mobile);

}
