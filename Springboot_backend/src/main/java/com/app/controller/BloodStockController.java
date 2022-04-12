package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.BloodStock;
import com.app.service.IBloodStockService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/stock")
public class BloodStockController {
	
	BloodStockController(){
		System.out.println("BloodStockController");
	}
	
	@Autowired
	private IBloodStockService stockService;
	
	
	@GetMapping("/{email}")
	public BloodStock getBloodStockByEmail(@PathVariable String email){
		System.out.println("getBloodStockByEmail"+email);
		return stockService.getBloodStockByEmail(email);
		
	}
	
	@PostMapping("/update")
	public BloodStock updateBloodStock(@RequestBody BloodStock stock){
		System.out.println("updateBloodStock"+stock);
		return stockService.updateBloodStock(stock);
	}
	
	@GetMapping("/all")
	public List<BloodStock> getAllBloodStock(){
		System.out.println("getAllBloodStock");
		return stockService.getAllBloodStock();
		
	}
	

	@GetMapping("/city/{cityId}")
	public List<BloodStock> getAllBloodStockOfCity(@PathVariable int cityId){
		System.out.println("GetAllAcceptedBloodBank");
		List<BloodStock> list=stockService.getAllBloodStockOfCity(cityId);
		System.out.println(list);
		return list;
		//return null;
	}
	
	@GetMapping("/district/{districtId}")
	public List<BloodStock> GetAllBloodStockOfDistrict(@PathVariable int districtId){
		System.out.println("GetAllAcceptedBloodBankOfDistrict");
		List<BloodStock> list=stockService.getAllBloodStockOfDistrict(districtId);
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/state/{stateId}")
	public List<BloodStock> getAllBloodStockOfState(@PathVariable int stateId){
		System.out.println("GetAllAcceptedBloodBankOfState");
		List<BloodStock> list=stockService.getAllBloodStockOfState(stateId);
		System.out.println(list);
		return list;
	}
	
	
	
	
	
	
	
}
