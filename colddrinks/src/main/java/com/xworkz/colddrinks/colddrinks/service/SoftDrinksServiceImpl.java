package com.xworkz.colddrinks.colddrinks.service;

import java.util.List;

import com.xworkz.colddrinks.colddrinks.dao.SoftDrinksDAO;
import com.xworkz.colddrinks.colddrinks.dao.SoftDrinksDAOImpl;
import com.xworkz.colddrinks.colddrinks.dto.SoftDrinksDTO;

public class SoftDrinksServiceImpl implements SoftDrinksService{
private SoftDrinksDAO sDAO;
	
	public SoftDrinksServiceImpl() {
		sDAO = new SoftDrinksDAOImpl();
	}

	@Override
	public void validateAndSave(SoftDrinksDTO cDTO) {
		if(cDTO!=null) {
			sDAO.save(cDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<SoftDrinksDTO> validateAndGetAllDetails() {
		return sDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			sDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			sDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	@Override
	public String validateAndGetSoftdrinkColorBySoftdrinkName(String name) {
		if(name!=null) {
			return sDAO.getSoftdrinkColorBySoftdrinkName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public SoftDrinksDTO validateAndGetDetailsBySoftdrinkName(String name) {
		if(name!=null) {
			return sDAO.getDetailsBySoftdrinkName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetSoftdrinkManufactureYearAndPricesBySoftdrinkName(String name) {
		if(name!=null) {
			return sDAO.getSoftdrinkManufactureYearAndPricesBySoftdrinkName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(int mfgYear) {
		if(mfgYear!=0) {
			return sDAO.getsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(mfgYear);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdatePriceByNameH(String name, double price) {
		if(name!=null) {
			return sDAO.updatePriceByNameH(name,price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateColorByNameH(String name, String color) {
		if(name!=null) {
			return sDAO.updateColorByNameH(name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdatesoftdrinkmfgyearByNameH(String name, int mfgyear) {
		if(name!=null) {
			return sDAO.updateColorByNameH(name,mfgyear);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return sDAO.deleteColorByNameH(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByPriceH(double price) {
		if(price!=0) {
			return sDAO.deleteColorByPriceH(price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByColorH(String color) {
		if(color!=null) {
			return sDAO.deleteColorByColorH(color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}


	
	
	
}
