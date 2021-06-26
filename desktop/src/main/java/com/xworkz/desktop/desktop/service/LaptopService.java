package com.xworkz.desktop.desktop.service;

import java.util.List;

import com.xworkz.desktop.desktop.dto.LaptopDTO;

public interface LaptopService {
	public void save(LaptopDTO laptopDTO);

	public LaptopDTO getLaptopByName(int id);

	public void updatePriceByName(int id, String name, double price);

	public void deleteByName(int id, String name);
	
	public List<LaptopDTO> getAllLoptop();

	public LaptopDTO getLaptopByLaptopId(int id);

	public String getColorByLaptopName(String pname);

	public Object[] getNameAndPriceByColor(String color);
	
	public List<Object[]> getAllNameAndPriceByColor(String cname);
	
	int updatePriceByName(String name,double price);

	int updateColorByName(String name, String color);

	int deleteByName(String name);

	int deleteByPrice(double price);


}
