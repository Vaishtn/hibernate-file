package com.xworkz.ac1.ac1.service;

import java.util.List;

import com.xworkz.ac1.ac1.dao.FanDAO;
import com.xworkz.ac1.ac1.dao.FanDAOImpl;
import com.xworkz.ac1.ac1.dto.FanDTO;

public class FanServiceImpl implements FanService{
private FanDAO pDAO;
	
	public FanServiceImpl() {
		pDAO = new FanDAOImpl();
	}
	@Override
	public void save(FanDTO fanDTO) {
		// TODO Auto-generated method stub
		if (fanDTO != null) {
			pDAO.save(fanDTO);
		} else {
			System.out.println("object cant be empty");
		}

	}

	@Override
	public FanDTO getFanByName(int id) {
		if (id > 0) {
			return pDAO.getFanByName(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public void updatePriceByName(int id, String name, double price) {
		// TODO Auto-generated method stub
		if (name != null) {
			pDAO.updatePriceByName(id, name, price);
		} else {
			System.out.println("Name cannot be null");
		}

	}

	@Override
	public void deleteByName(int id, String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			pDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}

	}

	@Override
	public List<FanDTO> getAllFan() {
		// TODO Auto-generated method stub
		return pDAO.getAllFan();
	}

	@Override
	public FanDTO getFanByFanId(int id) {
		// TODO Auto-generated method stub
		return pDAO.getFanByFanId(id);
	}

	@Override
	public String getColorByFanName(String fanName) {
		// TODO Auto-generated method stub
		return pDAO.getColorByFanName(fanName);
	}

	@Override
	public Object[] getNameAndPriceByColor(String fname) {
		// TODO Auto-generated method stub
		return pDAO.getNameAndPriceByColor(fname);
	}

	@Override
	public List<Object[]> getAllNameAndPriceByColor(String color) {
		// TODO Auto-generated method stub
		return pDAO.getAllNameAndPriceByColor(color);
	}

	@Override
	public int updatePriceByName(String name, double price) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return pDAO.updatePriceByName(name,price);
		}
		return 0;
	}

	@Override
	public int updateColorByName(String name, String color) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return pDAO.updateColorByName(name,color);
		}
		return 0;
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return pDAO.deleteByName(name);
		}
		return 0;
	}

	@Override
	public int deleteByPrice(double price) {
		// TODO Auto-generated method stub
		if(price!=0) {
			return pDAO.deleteByPrice(price);
		}
		return 0;
	}


}
