package com.xworkz.sweet.sweetapp.service;

import com.xworkz.sweet.sweetapp.dao.SweetsDAO;
import com.xworkz.sweet.sweetapp.dao.SweetsDAOImpl;
import com.xworkz.sweet.sweetapp.dto.SweetsDTO;

public class SweetsServiceImpl implements SweetsService{
private SweetsDAO sDAO ;
	
	public SweetsServiceImpl() {
		sDAO = new SweetsDAOImpl();
	}

	public void valideAndSave(SweetsDTO sDTO) {
		if(sDTO!=null) {
			sDAO.save(sDTO);
		}
		else {
			System.out.println("object cant be empty");
		}
	}

	public SweetsDTO validateAndGetDetailsByName(int id, String name) {
		if(name!=null) {
			return sDAO.getDetailsByName(id,name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	public void validateAndUpdate(int id, String name, String color) {
		if(name!=null) {
			sDAO.updateColorByName(id,name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	public void validateAndDelete(int id, String name) {
		if(name!=null) {
			sDAO.deleteByName(id,name);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}
}
