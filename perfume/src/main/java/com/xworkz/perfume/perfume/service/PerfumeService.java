package com.xworkz.perfume.perfume.service;

import java.util.List;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public interface PerfumeService {
	void vaidateAndSave(PerfumeDTO pDTO);

	public PerfumeDTO validateAndGetDetailsByName(int id, String name);

	void validateAndUpdateColorByName(int id, String name, String color);

	void validateAndDeleteDetailsByName(int id, String name);

	List<PerfumeDTO> validateAndGetAllDetails();

	String validateAndGetPerfumeFragnanceByPerfumeName(String name);

	PerfumeDTO validateAndGetDetailsByperfumeName(String name);

	Object[] validateAndGetperfumeColorAndPricesByPerfumeName(String name);

	List<Object[]> validateAndGetperfumePriceAndperfumeColorByperfumeFragnance(String fragnance);

	int validateAndUpdatePriceByNameH(String name, double price);

	int validateAndUpdateColorByNameH(String name, String color);

	int validateAndUpdateperfumeFragnanceByNameH(String name, String fragnance);

	int validateAndDeleteByNameH(String name);

	int validateAndDeleteByPriceH(double price);

	int validateAndDeleteByColorH(String color);

	


}
