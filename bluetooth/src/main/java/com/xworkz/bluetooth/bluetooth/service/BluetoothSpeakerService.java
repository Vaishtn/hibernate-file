package com.xworkz.bluetooth.bluetooth.service;

import java.util.List;

import com.xworkz.bluetooth.bluetooth.dto.BluetoothSpeakerDTO;

public interface BluetoothSpeakerService {
	void validateAndSave(BluetoothSpeakerDTO bluetoothSpeakerDTO);

	public BluetoothSpeakerDTO validateAndGetBrandById(int id);
	
	public List<BluetoothSpeakerDTO> validateAndGetAllDetails();

	void validateAndDeleteById(int id);

	void validateAndUpdateRangeByName(int id,String range);

	String validateAndGetBluetoothNameByBrand(String brand);


	BluetoothSpeakerDTO validateAndGetDetailsByBluetoothBrand(String brand);

	Object[] validateAndGetBluetoothRangeAndbluetoothNameByBrand(String next);

}
