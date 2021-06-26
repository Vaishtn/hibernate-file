package com.xworkz.desktop.desktop;

import com.xworkz.desktop.desktop.dto.LaptopDTO;
import com.xworkz.desktop.desktop.service.LaptopService;
import com.xworkz.desktop.desktop.service.LaptopServiceImpl;

public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LaptopDTO dto = new LaptopDTO();
		dto.setLaptopName("Sony");
		dto.setLaptopColor("black");
		dto.setLaptopPrice(65000.00);

		LaptopService service = new LaptopServiceImpl();
//		service.save(dto);
		
		LaptopDTO dto1 = service.getLaptopByLaptopId(1);
		System.out.println(dto1);
		
//		service.updatePriceByName(3, "hp", 45000.00);
		
	//	service.deleteByName(3, "hp");
		
//		List<LaptopDTO> dtos = service.getAllLoptop();
//		dtos.forEach(System.out::println);

//		LaptopDTO fanDTOFromDB = service.getLaptopByName(2);
//		System.out.println(fanDTOFromDB);
//		
//		String cn = service.getColorByLaptopName("Lenovo");
//		System.out.println(cn);

//		Object[] object = service.getNameAndPriceByColor("silver");
//		for (Object object2 : object) {
//			System.out.println(object2);
//		}
//
//		int i = service.updatePriceByName("Sony", 75000.00);
//		System.out.println(i);
//		
//		int i = service.updateColorByName("Lenovo", "silver");
//		System.out.println(i);

//		int k = service.deleteByName("Mac");
//		System.out.println(k);
		
//		int l = service.deleteByPrice(65000.00);
//		System.out.println(l);
		
	}

}
