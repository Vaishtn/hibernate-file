package com.xworkz.sweet.sweetapp;

import java.util.Scanner;

import com.xworkz.sweet.sweetapp.dto.SweetsDTO;
import com.xworkz.sweet.sweetapp.service.SweetsService;
import com.xworkz.sweet.sweetapp.service.SweetsServiceImpl;

public class Tester {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		SweetsService sweetsService = new SweetsServiceImpl();
		
		System.out.println("Enter no of records you need to enter");
		int input = scanner.nextInt();
		for(int i=0;i<input;i++) {
		SweetsDTO sDTO = new SweetsDTO() ;
		System.out.println("Enter id");
		sDTO.setSweet_id(scanner.nextInt());
		System.out.println("Enter sweet name");
		sDTO.setName(scanner.next());
		System.out.println("Enter sweet color");
		sDTO.setColor(scanner.next());
		System.out.println("Enter price of sweet");
		sDTO.setPrice(scanner.nextDouble());
		System.out.println("Enter shape of sweet");
		sDTO.setShape(scanner.next());
		sweetsService.valideAndSave(sDTO);
		
		} 
		System.out.println("Enter no of records you need to fetch by name");
		int input1 = scanner.nextInt();
		for(int i=0;i<input1;i++) {
		System.out.println("Enter sweet ID");
		System.out.println("Enter sweet Name");
	
		SweetsDTO sDTO =sweetsService.validateAndGetDetailsByName(scanner.nextInt(),scanner.next());
		System.out.println(sDTO);
		
		} 
		System.out.println("Enter no of records you need to update color by name");
		int input2 = scanner.nextInt();
		for(int i=0;i<input2;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name");
			System.out.println("Enter color to change");
			sweetsService.validateAndUpdate(scanner.nextInt(),scanner.next(),scanner.next());
			System.out.println("Details updated");
			
		}
		System.out.println("Enter no of records you need to delete by name");
		int input3 = scanner.nextInt();
		for(int i=0;i<input3;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name to delete");
			sweetsService.validateAndDelete(scanner.nextInt(),scanner.next());
			System.out.println("Details deleted");
			
		}
		scanner.close();




}
}
