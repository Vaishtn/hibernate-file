package com.xworkz.bluetooth.bluetooth.dao;

import java.util.List;

import com.xworkz.bluetooth.bluetooth.dto.BluetoothSpeakerDTO;

public interface BluetoothSpeakerDAO {
	void save(BluetoothSpeakerDTO bluetoothSpeakerDTO);

	public BluetoothSpeakerDTO getBrandById(int id);

	public List<BluetoothSpeakerDTO> getAllDetails();

	void deleteById(int id);

	void updateRangeByName(int id,String range);

	BluetoothSpeakerDTO getDetailsByBluetoothBrand(String brand);

	String getBluetoothNameByBrand(String brand);

	Object[] getBluetoothRangeAndbluetoothNameByBrand(String brand);
	List<Object[]> getbluetoothRangeAndbluetoothNameBybluetoothCompanyName(String brand);

	int updateNameByBrandH(String brand, String name);

	int updateRangeByNameH(String brand, String range);

	int deleteByBrandH(String brand);

	int deleteByRangeH(String range);


	int deleteByBluetoothNameH(String bluetoothName);




}
