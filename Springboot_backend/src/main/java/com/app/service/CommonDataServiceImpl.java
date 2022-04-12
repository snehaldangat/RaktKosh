package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CityRepository;
import com.app.dao.DistrictRepository;
import com.app.dao.StateRepository;
import com.app.dao.UserRepository;
import com.app.pojos.City;
import com.app.pojos.District;
import com.app.pojos.State;
import com.app.pojos.User;

@Service
@Transactional
public class CommonDataServiceImpl implements ICommonDataService {
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private DistrictRepository districtRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<State> getAllStates(){
		
		return stateRepo.findAll();
	}

	@Override
	public List<City> getAllCitiesByDistrictId(int districtId) {
		// TODO Auto-generated method stub
		return cityRepo.getAllCitiesByDistrictId(districtId);
	}

	@Override
	public List<District> getAllDistrictsByStateId(int stateId) {
		// TODO Auto-generated method stub
		return districtRepo.getAllDistrictsByStateId(stateId);
	}

	@Override
	public User userLogin(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("userLogin Ser");
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User getUserByEmailId(String email) {
		// TODO Auto-generated method stub
		return userRepo.featchById(email);
	}
}
