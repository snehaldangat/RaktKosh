package com.app.service;

import java.util.List;

import com.app.pojos.BloodStock;

public interface IBloodStockService {
	
	BloodStock getBloodStockByEmail(String email);

	List<BloodStock> getAllBloodStock();

	BloodStock updateBloodStock(BloodStock stock);

	List<BloodStock> getAllBloodStockOfCity(int cityId);

	List<BloodStock> getAllBloodStockOfDistrict(int districtId);

	List<BloodStock> getAllBloodStockOfState(int stateId);

	

}
