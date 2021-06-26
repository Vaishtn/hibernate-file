package com.xworkz.paytm.paytm.service;

import java.util.List;

import com.xworkz.paytm.paytm.dao.PaymentMerchantDAO;
import com.xworkz.paytm.paytm.dao.PaymentMerchantDAOImpl;
import com.xworkz.paytm.paytm.dto.PaymentMerchantDTO;

public class PaymentMerchantServiceImpl implements PaymentMerchantService{
private PaymentMerchantDAO pmDAO;
	
	public PaymentMerchantServiceImpl() {
		pmDAO= new PaymentMerchantDAOImpl();
	}

	public void validateAndSaveDetails(PaymentMerchantDTO pDTO) {
		if(pDTO!=null) {
			pmDAO.save(pDTO);
		}
		else {
			System.out.println("dto cant be null");
		}
	}

	public PaymentMerchantDTO validateAndFetchDetailsByName(String name) {
		if(name!=null) {
			return pmDAO.fetchDetailsByName(name);
		}
		else {
			System.out.println("dto cant be null");
		}
		return null;
	}

	public Object[] validateAndFetchCEOAndEmailDetailsByName(String name) {
		if(name!=null) {
			return pmDAO.fetchCEOAndEmailDetailsByName(name);
		}
		else {
			System.out.println("name cant be null");
		}
		return null;
	}

	public List<Object[]> validateAndFetchAllCEOAndEmailDetailsByLocation(String hqLocation) {
		if(hqLocation!=null) {
			return pmDAO.fetchAllCEOAndEmailDetailsByLocation(hqLocation);
		}
		else {
			System.out.println("name cant be null");
		}
		return null;
	}

	public int validateAndUpdateCEOByName(String name,String ceo) {
		if(ceo!=null) {
			return pmDAO.updateCEOByName(name,ceo);
		}
		else {
			System.out.println("name cant be null");
		}
		return 0;
	}

	public int validateAndDeleteDetailsByLocation(String hq) {
		if(hq!=null) {
			return pmDAO.deleteDetailsByHq(hq);
		}
		else {
			System.out.println("name cant be null");
		}
		return 0;
	}
}
