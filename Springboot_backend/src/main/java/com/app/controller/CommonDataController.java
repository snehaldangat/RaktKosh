package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.City;
import com.app.pojos.District;
import com.app.pojos.State;
import com.app.pojos.User;
import com.app.service.ICommonDataService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/commondata")
public class CommonDataController {
	@Autowired
	private ICommonDataService commonService;
	
	public CommonDataController() {
		System.out.println("in ctor"+getClass());
	}
	@GetMapping("/allstates")
	public List<State> getAllStateDetails(){
		System.out.println("getAllStateDetails");
		return commonService.getAllStates();
	}
	
	@GetMapping("/cities/{districtId}")
	public List<City> getAllCityDetailsByDistrictId(@PathVariable int districtId){
		System.out.println("getAllCityDetailsByDistrictId"+districtId);
		return commonService.getAllCitiesByDistrictId(districtId);
	}
	
	@GetMapping("/districts/{stateId}")
	public List<District> getAllDistrictsDetailsByStateId(@PathVariable int stateId){
		System.out.println("getAllDistrictsDetailsByStateId"+stateId);
		return commonService.getAllDistrictsByStateId(stateId);
	}
	
	@GetMapping("/verifyemail/{email}")
	public boolean getVerifyEmail(@PathVariable String email){
		System.out.println("getUserByEmailId"+email);
		User user=commonService.getUserByEmailId(email);
		System.out.println(user);
		if(user== null) {
		return true;
		}
		else {
			return false;
		}
	}
	
	@GetMapping("/login/{email}/{password}")
	public User userLogin(@PathVariable String email, @PathVariable String  password, HttpSession session) {
		System.out.println(" "+email+" "+password);
		User user= commonService.userLogin(email, password);
		session.setAttribute("user_data", user);
		return user;
	}
	
	@GetMapping("/sessionuser")
	public User getSessionUser( HttpSession session) {
		
		User user= (User) session.getAttribute("user_data");
		System.out.println(user);
		if(user==null)
			return null;
		System.out.println("getSessionUser"+user.toString());
		return user;
	}

}
