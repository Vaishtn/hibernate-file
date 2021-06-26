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
	@Override
	public List<Object[]> validateAndGetbluetoothRangeAndbluetoothNameBybluetoothCompanyName(String brand) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.getbluetoothRangeAndbluetoothNameBybluetoothCompanyName(brand);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return null;
	}


	@Override
	public int validateAndUpdateNameByBrandH(String brand, String name) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.updateNameByBrandH(brand,name);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return 0;
	}


	@Override
	public int validateAndUpdateRangeByNameH(String brand, String range) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.updateRangeByNameH(brand,range);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return 0;
	}


	@Override
	public int validateAndDeleteByBrandH(String brand) {
		if(brand!=null) {
			
			return bluetoothSpeakerDAO.deleteByBrandH(brand);
		}
		else {
			System.out.println("Brand cant be empty");
		}
		return 0;
	}


	@Override
	public int validateAndDeleteByRangeH(String range) {
		if(range!=null) {
			
			return bluetoothSpeakerDAO.deleteByRangeH(range);
		}
		else {
			System.out.println("Range cant be empty");
		}
		return 0;
	}


	@Override
	public int validateAndDeleteByBluetoothNameH(String bluetoothName) {
if(bluetoothName!=null) {
			
			return bluetoothSpeakerDAO.deleteByBluetoothNameH(bluetoothName);
		}
		else {
			System.out.println("bluetooth name cant be empty");
		}
		return 0;
	}


}
