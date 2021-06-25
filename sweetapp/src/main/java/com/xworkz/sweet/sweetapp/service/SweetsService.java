package com.xworkz.sweet.sweetapp.service;

import com.xworkz.sweet.sweetapp.dto.SweetsDTO;

public interface SweetsService {
	void valideAndSave(SweetsDTO sDTO);

	public SweetsDTO validateAndGetDetailsByName(int id, String name);

	public void validateAndUpdate(int id, String name, String color);

	void validateAndDelete(int id, String name);

}
