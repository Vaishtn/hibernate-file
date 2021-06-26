package com.xworkz.perfume.perfume.service;

import java.util.List;

import com.xworkz.perfume.perfume.dao.PerfumeDAO;
import com.xworkz.perfume.perfume.dao.PerfumeDAOImpl;
import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public class PerfumeServiceImpl implements PerfumeService{
private PerfumeDAO pDAO;
	
	public PerfumeServiceImpl() {
		 pDAO = new PerfumeDAOImpl();
	}

	public void vaidateAndSave(PerfumeDTO pDTO) {
		if(pDTO!=null) {
			
			pDAO.save(pDTO);
			
		}
		
	}

	public PerfumeDTO validateAndGetDetailsByName(int id, String name) {
		
		if(name!=null) {
			return pDAO.getDetailsByName(id,name);	
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
		
	}

	public void validateAndUpdateColorByName(int id, String name, String color) {
		if(name!=null) {
			pDAO.updateColorByName(id,name,color);
		}
		else {
			System.out.println("name cant be empty");
		}
		
	}

	public void validateAndDeleteDetailsByName(int id, String name) {
		if(name!=null) {
			pDAO.deleteDetailsByName(id,name);
		}
		else {
			System.out.println("name cant be empty");
		}
	}

	@Override
	public List<PerfumeDTO> validateAndGetAllDetails() {
		
		return pDAO.getAllDetails();
	}

	@Override
	public String validateAndGetPerfumeFragnanceByPerfumeName(String name) {
		if(name!=null) {
			return pDAO.getPerfumeFragnanceByPerfumeName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}

	@Override
	public PerfumeDTO validateAndGetDetailsByperfumeName(String name) {
		if(name!=null) {
			return pDAO.getDetailsByperfumeName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetperfumeColorAndPricesByPerfumeName(String name) {
		if(name!=null) {
			return pDAO.getperfumeColorAndPricesByPerfumeName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetperfumePriceAndperfumeColorByperfumeFragnance(String fragnance) {
		if(fragnance!=null) {
			return pDAO.getperfumePriceAndperfumeColorByperfumeFragnance(fragnance);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}

	@Override
	public int validateAndUpdatePriceByNameH(String name, double price) {
		if(name!=null) {
			return pDAO.updatePriceByNameH(name,price);
		}
		else {
			System.out.println("name cant be empty");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateColorByNameH(String name, String color) {
		if(name!=null) {
			return pDAO.updateColorByNameH(name,color);
		}
		else {
			System.out.println("name cant be empty");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateperfumeFragnanceByNameH(String name, String fragnance) {
		if(name!=null) {
			return pDAO.updateperfumeFragnanceByNameH(name,fragnance);
		}
		else {
			System.out.println("name cant be empty");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return pDAO.deleteByNameH(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByPriceH(double price) {
		if(price!=0) {
			return pDAO.deleteByPriceH(price);
		}
		else {
			System.out.println("price cant be 0");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByColorH(String color) {
		if(color!=null) {
			return pDAO.deleteByColorH(color);
		}
		else {
			System.out.println("color cant be empty");
		}
		return 0;
	}

}
