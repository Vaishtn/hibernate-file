package com.xworkz.colddrinks.colddrinks;

import java.util.List;
import java.util.Scanner;

import com.xworkz.colddrinks.colddrinks.dto.SoftDrinksDTO;
import com.xworkz.colddrinks.colddrinks.service.SoftDrinksService;
import com.xworkz.colddrinks.colddrinks.service.SoftDrinksServiceImpl;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SoftDrinksDTO sDTO = new SoftDrinksDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter softdrink name");
			sDTO.setName(sc.next());
			System.out.println("Enter softdrink color");
			sDTO.setColor(sc.next());
			System.out.println("Enter softdrink price");
			sDTO.setPrice(sc.nextDouble());
			System.out.println("Enter softdrink mfg year");
			sDTO.setMfgYear(sc.nextInt());
			
			SoftDrinksService cs = new SoftDrinksServiceImpl();
			cs.validateAndSave(sDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SoftDrinksService sService = new SoftDrinksServiceImpl();
			List<SoftDrinksDTO > sfDTOs = sService.validateAndGetAllDetails();
			sfDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of softdrink to update color");
			System.out.println("Enter correct id of softdrink");
			System.out.println("Enter new Color");
			
			SoftDrinksService sService = new SoftDrinksServiceImpl();
			sService.validateAndUpdateColorByName(sc.next(),sc.nextInt(),sc.next());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of softdrinks to delete");
			System.out.println("Enter softdrink id of chocolate");
			SoftDrinksService softService = new SoftDrinksServiceImpl();
			softService.validateAndDeleteColorByName(sc.next(),sc.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get softdrink color by softdrink  name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter softdrink  name");
			SoftDrinksService sftDrnkService= new SoftDrinksServiceImpl();
			String colu = sftDrnkService.validateAndGetSoftdrinkColorBySoftdrinkName(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  softdrink by softdrink  name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter softdrink  name");
			SoftDrinksService ssoftDrinksService= new SoftDrinksServiceImpl();
			SoftDrinksDTO  sfDTO  = ssoftDrinksService.validateAndGetDetailsBySoftdrinkName(sc.next());
			System.out.println(sfDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  softdrink manufactur year & price by softdrink name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter softdrink  name");
			SoftDrinksService  sftDService= new SoftDrinksServiceImpl();
			Object obj[] = sftDService.validateAndGetSoftdrinkManufactureYearAndPricesBySoftdrinkName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		System.out.println("H: Press \"Y\" to get  softdrink price & color details  by softdrink mfgyear,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter softdrink mfgyear");
			SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
			List<Object[]> objec = softdrinkService.validateAndGetsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(sc.nextInt());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update softdrink price by softdrink name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of softdrink ");
				System.out.println("Enter new price");
				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndUpdatePriceByNameH(sc.next(),sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update softdrink color by name  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of softdrink ");
				System.out.println("Enter new color");
				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndUpdateColorByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update softdrink mfgyear  by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of softdrink ");
				System.out.println("Enter new mfgyear");
				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndUpdatesoftdrinkmfgyearByNameH(sc.next(),sc.nextInt());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete softdrink details by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of softdrink ");				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete softdrink details by price  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter price ");				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndDeleteByPriceH(sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete softdrink details by color  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				SoftDrinksService softdrinkService = new SoftDrinksServiceImpl();
				int rowAffected=softdrinkService.validateAndDeleteByColorH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		sc.close();

	}
		


}
