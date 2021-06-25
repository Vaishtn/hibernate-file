package com.xworkz.bluetooth.bluetooth.service;

import java.util.List;

import com.xworkz.bluetooth.bluetooth.dao.BluetoothSpeakerDAO;
import com.xworkz.bluetooth.bluetooth.dao.BluetoothSpeakerDAOImpl;
import com.xworkz.bluetooth.bluetooth.dto.BluetoothSpeakerDTO;

public class BluetoothSpeakerServiceImpl implements BluetoothSpeakerService {
private BluetoothSpeakerDAO bluetoothSpeakerDAO ;
	
	public BluetoothSpeakerServiceImpl(){
		
		bluetoothSpeakerDAO = new BluetoothSpeakerDAOImpl();
		
		
	}
	

	public void validateAndSave(BluetoothSpeakerDTO bluetoothSpeakerDTO) {
		if(bluetoothSpeakerDTO!=null) {
			
			bluetoothSpeakerDAO.save(bluetoothSpeakerDTO);
		}
		else {
			System.out.println("object cant be empty");
		}
		
		
		
	}


	public BluetoothSpeakerDTO validateAndGetBrandById(int id) {
		if(id>0) {
			return bluetoothSpeakerDAO.getBrandById(id);
			
		}
		return null;
				
		
	}


	public List<BluetoothSpeakerDTO> validateAndGetAllDetails() {
		return bluetoothSpeakerDAO.getAllDetails();
	}


	public void validateAndDeleteById(int id) {
		if(id>0) {
			 bluetoothSpeakerDAO.deleteById(id);
			
		}
		
	}


	public void validateAndUpdateRangeByName(int id,String range) {
		if(id!=0) {
			
			bluetoothSpeakerDAO.updateRangeByName(id,range);
		}
		else {
			System.out.println("id cant be empty");
		}
	}


	@Override
	public String validateAndGetBluetoothNameByBrand(String brand) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.getBluetoothNameByBrand(brand);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return null;
	}


	@Override
	public BluetoothSpeakerDTO validateAndGetDetailsByBluetoothBrand(String brand) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.getDetailsByBluetoothBrand(brand);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		
		return null;
	}


	@Override
	public Object[] validateAndGetBluetoothRangeAndbluetoothNameByBrand(String brand) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.getBluetoothRangeAndbluetoothNameByBrand(brand);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return null;
	}

}
