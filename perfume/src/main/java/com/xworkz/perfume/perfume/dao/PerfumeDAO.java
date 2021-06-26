package com.xworkz.perfume.perfume.dao;

import java.util.List;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public interface PerfumeDAO {
	void save(PerfumeDTO pDTO);

	public PerfumeDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteDetailsByName(int id, String name);

	List<PerfumeDTO> getAllDetails();

	String getPerfumeFragnanceByPerfumeName(String name);

	PerfumeDTO getDetailsByperfumeName(String name);

	Object[] getperfumeColorAndPricesByPerfumeName(String name);

	List<Object[]> getperfumePriceAndperfumeColorByperfumeFragnance(String fragnance);

	int updatePriceByNameH(String name,double price);

	int updateColorByNameH(String name, String color);

	int updateperfumeFragnanceByNameH(String name, String fragnance);

	int deleteByNameH(String name);

	int deleteByPriceH(double price);

	int deleteByColorH(String color);

}
