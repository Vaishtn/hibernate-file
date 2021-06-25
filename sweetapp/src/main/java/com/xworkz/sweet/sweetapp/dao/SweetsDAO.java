package com.xworkz.sweet.sweetapp.dao;

import com.xworkz.sweet.sweetapp.dto.SweetsDTO;

public interface SweetsDAO {
	public void save(SweetsDTO sDTO);

	public SweetsDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteByName(int id, String name);

}
