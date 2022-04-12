package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BloodBankRepository;
import com.app.dao.BloodStockRepository;
import com.app.dao.UserRepository;
import com.app.pojos.BloodBank;
import com.app.pojos.BloodStock;
import com.app.pojos.ReqStatus;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Service
@Transactional
public class BloodBankServiceImpl implements IBloodBankService {
	
	@Autowired
	private BloodBankRepository bankRepo;
	
	@Autowired
	private BloodStockRepository stockRepo;
	

	@Autowired
	private UserRepository userRepo;

	
	@Override
	public BloodBank addBank(BloodBank bank) {
		// TODO Auto-generated method stub
		return bankRepo.save(bank);
	}

	@Override
	public List<BloodBank> getAllBanks() {
		// TODO Auto-generated method stub
		return bankRepo.findAll();
	}

	@Override
	public Optional<BloodBank> getBankByEmailId(String email) {
		// TODO Auto-generated method stub
		  
		 return bankRepo.findById(email);
	}

	@Override
	public BloodBank getBankByContactId(String contact) {
		// TODO Auto-generated method stub
		BloodBank bank=bankRepo.getBankByContactId(contact);
		System.out.println(bank);
		return  bank;
	}

	@Override
	public List<BloodBank> addAllBank(List<BloodBank> bankList) {
		// TODO Auto-generated method stub
		return bankRepo.saveAll(bankList);
	}

	@Override
	public List<BloodStock> RegisterBloodBank(List<String> emailList) {
		// TODO Auto-generated method stub
		ArrayList<BloodStock> list=new ArrayList<BloodStock>();
		for (String email : emailList) {
			BloodStock stock=new BloodStock();
			//stock.setBank(null);
			BloodBank bank=bankRepo.featchById(email);
			stock.setBank(bank);
			stock=stockRepo.save(stock);
            bank.setStatus(ReqStatus.ACCEPTED);
            list.add(stock);
            User user=new User();
            user.setEmail(bank.getEmail());
            user.setPassword(bank.getPassword());
            user.setRole(UserRole.BANK);
            System.out.println(userRepo.save(user));
        }
		
		return list;
	}

	@Override
	public List<BloodBank> GetAllPendingReqBloodBank() {
		// TODO Auto-generated method stub
		return bankRepo.GetAllPendingReqBloodBank();
	}

	@Override
	public List<BloodBank> RejectBloodBank(List<String> emailList) {
		// TODO Auto-generated method stub
		ArrayList<BloodBank> list=new ArrayList<BloodBank>();
		for (String email : emailList) {
			//BloodStock stock=new BloodStock();
			//stock.setBank(null);
			BloodBank bank=bankRepo.featchById(email);
//			stock.setBank(bank);
//			stock=stockRepo.save(stock);
            bank.setStatus(ReqStatus.REGECTED);
            list.add(bank);
        }
		
		return list;
	}

	@Override
	public BloodBank getBankByLicenceId(String licence) {
		// TODO Auto-generated method stub
		return bankRepo.getBankByLicenceId(licence);
	}

	@Override
	public List<BloodBank> GetAllAcceptedBloodBank() {
		// TODO Auto-generated method stub
		return bankRepo.GetAllAcceptedBloodBank();
	}

	@Override
	public List<BloodBank> GetAllAcceptedBloodBankOfCity(int cityId) {
		// TODO Auto-generated method stub
		return bankRepo.GetAllAcceptedBloodBankOfCity(cityId);
	}

	@Override
	public List<BloodBank> GetAllAcceptedBloodBankOfDistrict(int districtId) {
		// TODO Auto-generated method stub
		return bankRepo.GetAllAcceptedBloodBankOfDistrict(districtId);
	}

	@Override
	public List<BloodBank> GetAllAcceptedBloodBankOfState(int stateId) {
		// TODO Auto-generated method stub
		System.out.println("GetAllAcceptedBloodBankOfState"+stateId);
		List<BloodBank>list= bankRepo.GetAllAcceptedBloodBankOfState(stateId);
		System.out.println(list);
		return list;
	}
	
	
}
