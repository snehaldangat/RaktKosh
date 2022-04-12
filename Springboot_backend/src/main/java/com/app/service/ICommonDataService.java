package com.app.service;

import java.util.List;

import com.app.pojos.City;
import com.app.pojos.District;
import com.app.pojos.State;
import com.app.pojos.User;

public interface ICommonDataService {

	List<State> getAllStates();
	
	List<City> getAllCitiesByDistrictId(int districtId);

	List<District> getAllDistrictsByStateId(int stateId);
	
	User userLogin(String email, String password);

	User getUserByEmailId(String email);

}
