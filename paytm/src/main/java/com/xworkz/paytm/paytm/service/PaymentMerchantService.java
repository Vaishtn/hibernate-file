package com.xworkz.paytm.paytm.service;

import java.util.List;

import com.xworkz.paytm.paytm.dto.PaymentMerchantDTO;

public interface PaymentMerchantService {
	public void validateAndSaveDetails(PaymentMerchantDTO pDTO);

	public PaymentMerchantDTO validateAndFetchDetailsByName(String name);

	public Object[] validateAndFetchCEOAndEmailDetailsByName(String name);

	public List<Object[]> validateAndFetchAllCEOAndEmailDetailsByLocation(String hqLocation);

	public int validateAndUpdateCEOByName(String name,String ceo);

	public int validateAndDeleteDetailsByLocation(String hq);

}
