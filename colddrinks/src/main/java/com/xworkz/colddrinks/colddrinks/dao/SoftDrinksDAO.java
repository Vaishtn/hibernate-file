package com.xworkz.colddrinks.colddrinks.dao;

import java.util.List;

import com.xworkz.colddrinks.colddrinks.dto.SoftDrinksDTO;

public interface SoftDrinksDAO {
	public void save(SoftDrinksDTO cDTO);

	public List<SoftDrinksDTO> getAllDetails();

	public void updateColorByName(String name, int id, String color);

	public void deleteColorByName(String name, int id);

	public String getSoftdrinkColorBySoftdrinkName(String name);

	public SoftDrinksDTO getDetailsBySoftdrinkName(String name);

	public Object[] getSoftdrinkManufactureYearAndPricesBySoftdrinkName(String name);


	public List<Object[]> getsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(int mfgYear);

	public int updatePriceByNameH(String name, double price);

	public int updateColorByNameH(String name, String color);

	public int updateColorByNameH(String name, int mfgyear);

	public int deleteColorByNameH(String name);

	public int deleteColorByPriceH(double price);

	public int deleteColorByColorH(String color);


}
