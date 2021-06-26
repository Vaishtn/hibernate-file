package com.xworkz.colddrinks.colddrinks.service;

import java.util.List;

import com.xworkz.colddrinks.colddrinks.dto.SoftDrinksDTO;

public interface SoftDrinksService {
	public void validateAndSave(SoftDrinksDTO sDTO);

	public List<SoftDrinksDTO> validateAndGetAllDetails();

	public void validateAndUpdateColorByName(String name, int id, String color);

	public void validateAndDeleteColorByName(String name, int id);

	public String validateAndGetSoftdrinkColorBySoftdrinkName(String name);

	public SoftDrinksDTO validateAndGetDetailsBySoftdrinkName(String name);

	public Object[] validateAndGetSoftdrinkManufactureYearAndPricesBySoftdrinkName(String name);

	public List<Object[]> validateAndGetsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(int mfgYear);

	public int validateAndUpdatePriceByNameH(String name, double price);

	public int validateAndUpdateColorByNameH(String name, String color);

	public int validateAndUpdatesoftdrinkmfgyearByNameH(String name, int mfgyear);

	public int validateAndDeleteByNameH(String name);

	public int validateAndDeleteByPriceH(double price);

	public int validateAndDeleteByColorH(String color);


}
