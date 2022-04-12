package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BloodStockRepository;
import com.app.pojos.BloodStock;

@Service
@Transactional
public class BloodStockServiceImpl implements IBloodStockService {
	
	@Autowired
	private BloodStockRepository stockRepo;

	@Override
	public BloodStock getBloodStockByEmail(String email) {
		// TODO Auto-generated method stub
		return stockRepo.getBloodStockByEmail(email);
	}

	@Override
	public List<BloodStock> getAllBloodStock() {
		// TODO Auto-generated method stub
		return stockRepo.findAll();
	}

	@Override
	public BloodStock updateBloodStock(BloodStock stock) {
		// TODO Auto-generated method stub
		return stockRepo.save(stock);
	}

	@Override
	public List<BloodStock> getAllBloodStockOfCity(int cityId) {
		// TODO Auto-generated method stub
		return stockRepo.getAllBloodStockOfCity(cityId);
	}

	@Override
	public List<BloodStock> getAllBloodStockOfDistrict(int districtId) {
		// TODO Auto-generated method stub
		return stockRepo.getAllBloodStockOfDistrict(districtId);
	}

	@Override
	public List<BloodStock> getAllBloodStockOfState(int stateId) {
		// TODO Auto-generated method stub
		return stockRepo.getAllBloodStockOfState(stateId);
	}

	
	
}
