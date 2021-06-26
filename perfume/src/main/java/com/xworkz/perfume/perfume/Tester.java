package com.xworkz.perfume.perfume;

import java.util.List;
import java.util.Scanner;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;
import com.xworkz.perfume.perfume.service.PerfumeService;
import com.xworkz.perfume.perfume.service.PerfumeServiceImpl;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PerfumeService perfumeService = new PerfumeServiceImpl();
		System.out.println("Press \"Y\" to save details,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
		PerfumeDTO pDTO = new PerfumeDTO();
		System.out.println("Enter perfume name");
		pDTO.setPerfumeName(sc.next());
		System.out.println("Enter perfume fragnance");
		pDTO.setPerfumeFragnance(sc.next());
		System.out.println("Enter perfume color");
		pDTO.setPerfumeColor(sc.next());
		System.out.println("Enter perfume price");
		pDTO.setPerfumePrice(sc.nextDouble());
		
		
	
		perfumeService.vaidateAndSave(pDTO);
		}
		

		System.out.println("Press \"Y\" to details by name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
		System.out.println("Enter id and Name to fetch details");
		PerfumeDTO perDTO = perfumeService.validateAndGetDetailsByName(sc.nextInt(),sc.next());
		System.out.println(perDTO);
		System.out.println("details fetched");
		}
		
		System.out.println("Press \"Y\" to update color by name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
		System.out.println("Enter id ,perfume name,and new color");
		perfumeService.validateAndUpdateColorByName(sc.nextInt(),sc.next(),sc.next());
		System.out.println("updated");
		}
		
		
		System.out.println("Press \"Y\" to delete details by name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
		System.out.println("Delete detais by name:");
		System.out.println("Enter id ,perfume name to delete");
		perfumeService.validateAndDeleteDetailsByName(sc.nextInt(),sc.next());
		System.out.println("details deleted");
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			PerfumeService psService = new PerfumeServiceImpl();
			List<PerfumeDTO> pssDTOs = psService.validateAndGetAllDetails();
			pssDTOs.forEach(System.out::println);
		}
		
		System.out.println("Press \"Y\" to get perfume fragnance by perfume  name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter perfume  name");
			PerfumeService perrfumeService= new PerfumeServiceImpl();
			String colu = perrfumeService.validateAndGetPerfumeFragnanceByPerfumeName(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  perfume by perfume  name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter perfume  name");
			PerfumeService iperfumeService= new PerfumeServiceImpl();
			PerfumeDTO  perffDTO  = iperfumeService.validateAndGetDetailsByperfumeName(sc.next());
			System.out.println(perffDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  perfume color & price by perfume name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter perfume  name");
			PerfumeService  perfummService= new PerfumeServiceImpl();
			Object obj[] = perfummService.validateAndGetperfumeColorAndPricesByPerfumeName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		System.out.println("H: Press \"Y\" to get  perfume price & color details  by perfume fragnance,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter perfume fragnance");
			PerfumeService perfService = new PerfumeServiceImpl();
			List<Object[]> objec = perfService.validateAndGetperfumePriceAndperfumeColorByperfumeFragnance(sc.next());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update perfume price by perfume name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of perfume ");
				System.out.println("Enter new price");
				
				PerfumeService perfService = new PerfumeServiceImpl();
				int rowAffected=perfService.validateAndUpdatePriceByNameH(sc.next(),sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update perfume color by name  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of perfume ");
				System.out.println("Enter new color");
				
				PerfumeService perfService = new PerfumeServiceImpl();
				int rowAffected=perfService.validateAndUpdateColorByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update perfume fragnance  by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of perfume ");
				System.out.println("Enter new fragnance");
				
				PerfumeService perfService = new PerfumeServiceImpl();
				int rowAffected=perfService.validateAndUpdateperfumeFragnanceByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete perfume details by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of perfume ");				
				PerfumeService perfuuumService = new PerfumeServiceImpl();
				int rowAffected=perfuuumService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete perfume details by price  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter price ");				
				PerfumeService perfuuumService = new PerfumeServiceImpl();
				int rowAffected=perfuuumService.validateAndDeleteByPriceH(sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete perfume details by color  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				PerfumeService perfuuumService = new PerfumeServiceImpl();
				int rowAffected=perfuuumService.validateAndDeleteByColorH(sc.next());
				System.out.println(rowAffected);
			
			
		}
	
		sc.close();
	}


}
