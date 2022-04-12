package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.BloodBank;
import com.app.pojos.BloodStock;
import com.app.pojos.Donor;

public interface IBloodBankService {

	BloodBank addBank(BloodBank bank);

	List<BloodBank> getAllBanks();

	Optional<BloodBank> getBankByEmailId(String email);

	BloodBank getBankByContactId(String contact);
	
	BloodBank getBankByLicenceId(String licence);

	List<BloodBank> addAllBank(List<BloodBank> bankList);

	List<BloodStock> RegisterBloodBank(List<String> emailList);

	List<BloodBank> GetAllPendingReqBloodBank();

	List<BloodBank> RejectBloodBank(List<String> emailList);
	
	List<BloodBank> GetAllAcceptedBloodBank();
	
	List<BloodBank> GetAllAcceptedBloodBankOfCity(int cityId);
	
	List<BloodBank> GetAllAcceptedBloodBankOfDistrict(int districtId);
	
	List<BloodBank> GetAllAcceptedBloodBankOfState(int stateId);

}
