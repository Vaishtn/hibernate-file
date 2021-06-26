package com.xworkz.ac1.ac1.dao;

import java.util.List;

import com.xworkz.ac1.ac1.dto.FanDTO;

public interface FanDAO {
	public void save(FanDTO fanDTO);

	public FanDTO getFanByName(int id);

	public void updatePriceByName(int id, String name, double price);

	public void deleteByName(int id, String name);
	
	public List<FanDTO> getAllFan();

	public FanDTO getFanByFanId(int id);

	public String getColorByFanName(String fanName);

	public Object[] getNameAndPriceByColor(String fname);
	
	public List<Object[]> getAllNameAndPriceByColor(String color);
	
	int updatePriceByName(String name,double price);

	int updateColorByName(String name, String color);

	int deleteByName(String name);

	int deleteByPrice(double price);

}
