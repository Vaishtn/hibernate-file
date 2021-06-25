package com.xworkz.bluetooth.bluetooth;

import java.util.List;
import java.util.Scanner;

import com.xworkz.bluetooth.bluetooth.dto.BluetoothSpeakerDTO;
import com.xworkz.bluetooth.bluetooth.service.BluetoothSpeakerService;
import com.xworkz.bluetooth.bluetooth.service.BluetoothSpeakerServiceImpl;

public class Taster {
	public static void main(String[] args) {
		System.out.println("Bluetooth speaker data ");
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		for(int i=0;i<rec;i++) {
			System.out.println("enter id");
			int id1 = sc.nextInt();
			System.out.println("enter Bluetooth  Name");
			String s1 = sc.next();
			System.out.println("enter Bluetooth Speaker Brand");
			String s2 = sc.next();
			System.out.println("enter Bluetooth Speaker Range");
			String s3 = sc.next();
			
		BluetoothSpeakerDTO bluetoothSpeakerDTO = new BluetoothSpeakerDTO();
		bluetoothSpeakerDTO.setBluetoothId(id1);
		bluetoothSpeakerDTO.setBluetoothName(s1);
		bluetoothSpeakerDTO.setBrand(s2);
		bluetoothSpeakerDTO.setRange(s3);
		
		BluetoothSpeakerService bluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
		bluetoothSpeakerService.validateAndSave(bluetoothSpeakerDTO);
		
		}
		
		System.out.println("Enter no of details to get by ID:");
		
		int up = sc.nextInt();
		
		for(int j=0;j<up;j++) {
			int id4 = sc.nextInt();
		BluetoothSpeakerService bluetootSpeakerService = new BluetoothSpeakerServiceImpl();
		System.out.println("Enter id");
		BluetoothSpeakerDTO bD = bluetootSpeakerService.validateAndGetBrandById(id4);
		System.out.println(bD);
		}
		
		
		
		
		
		
		System.out.println("Enter number of records to delete");
		int del = sc.nextInt();
		
		for(int l=0;l<del;l++) {
		System.out.println("Enter id to delete ");
		int idd = sc.nextInt();		
		BluetoothSpeakerService blueToothSServic = new BluetoothSpeakerServiceImpl();
		blueToothSServic.validateAndDeleteById(idd);
		System.out.println("deleted");
		}
		
		System.out.println("Enter number of records to update by id");
		int uid = sc.nextInt();
		for(int m=0;m<uid;m++) {
			System.out.println("enter id to update");
			int iddd = sc.nextInt();
			System.out.println("enter new range");
			String rang = sc.next();
		BluetoothSpeakerService bluToothSService = new BluetoothSpeakerServiceImpl();
		System.out.println("updating details by range");
		bluToothSService.validateAndUpdateRangeByName(iddd,rang);
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			BluetoothSpeakerService bsService = new BluetoothSpeakerServiceImpl();
			List<BluetoothSpeakerDTO> buDTOs = bsService.validateAndGetAllDetails();
			buDTOs.forEach(System.out::println);
		}
		
		System.out.println("Press \"Y\" to get bluetooth name by bluetooth brand ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter bluetooth brand");
			BluetoothSpeakerService bluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
			String colu = bluetoothSpeakerService.validateAndGetBluetoothNameByBrand(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details  by bluetooth brand ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter bluetooth  brand");
			BluetoothSpeakerService bbluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
			BluetoothSpeakerDTO pnDTO  = bbluetoothSpeakerService.validateAndGetDetailsByBluetoothBrand(sc.next());
			System.out.println(pnDTO);
			
			
		}
		
		System.out.println("Press \"Y\" to get  bluetooth range & bluetooth name by bluetooth brand ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter bluetooth  brand");
			BluetoothSpeakerService bluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
			Object obj[] = bluetoothSpeakerService.validateAndGetBluetoothRangeAndbluetoothNameByBrand(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
			
			
		}

	}
}
