package com.xworkz.paytm.paytm;

import java.util.List;
import java.util.Scanner;

import com.xworkz.paytm.paytm.dto.PaymentMerchantDTO;
import com.xworkz.paytm.paytm.service.PaymentMerchantService;
import com.xworkz.paytm.paytm.service.PaymentMerchantServiceImpl;

public class Tester {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PaymentMerchantDTO pDTO = new PaymentMerchantDTO();
		PaymentMerchantService payService = new PaymentMerchantServiceImpl();
		
		System.out.println("Enter:");
		System.out.println("\"1\" to add new data");
		System.out.println("\"2\" to fetch data by name");
		System.out.println("\"3\" to fetch ceo and email by name ");
		System.out.println("\"4\" to fetch all ceo and email by location ");
		System.out.println("\"5\" to update ceo by name ");
		System.out.println("\"6\" to delete details by hq ");
		
		int num = sc.nextInt();
		switch(num) {
		case 1:System.out.println("Enter name of the payment merchant");
				pDTO.setName(sc.next());
				System.out.println("Enter CEO of payment merchant");
				pDTO.setCeo(sc.next());
				System.out.println("Enter HQ of  payment merchant");
				pDTO.setHq(sc.next());
				System.out.println("Enter email of payment merchant");
				pDTO.setEmail(sc.next());
				
				payService.validateAndSaveDetails(pDTO);
			break;
			
		case 2:System.out.println("Enter name of payment merchant to fetch details");
				pDTO = payService.validateAndFetchDetailsByName(sc.next());
				System.out.println(pDTO);
			break;
			
		case 3:System.out.println("Enter name of paymentmerchant to fetch CEO and Email details");
				Object[] obj = payService.validateAndFetchCEOAndEmailDetailsByName(sc.next());
				for(Object o :obj) {
					System.out.println(o);
				}
			
		
			break;
		case 4:System.out.println("Enter location of paymentmerchant to fetch CEO and Email details");
				List<Object[]> object = payService.validateAndFetchAllCEOAndEmailDetailsByLocation(sc.next());
				for(Object[] ob:object) {
					for(Object oc:ob) {
						System.out.println(oc);
					}
				}
		
		
			break;
		case 5:System.out.println("Enter name of paymentmerchant");
				System.out.println("Enter new ceo to update details by name");
				int rowAffected = payService.validateAndUpdateCEOByName(sc.next(),sc.next());
				System.out.println(rowAffected);
			break;
		
		case 6:System.out.println("Enter hq to delete details");
				int rowAffecte = payService.validateAndDeleteDetailsByLocation(sc.next());
				System.out.println(rowAffecte);
		
		
		
		
		}
		

	}


}
