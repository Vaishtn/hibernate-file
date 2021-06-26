package com.xworkz.ac1.ac1;

import com.xworkz.ac1.ac1.dto.FanDTO;
import com.xworkz.ac1.ac1.service.FanService;
import com.xworkz.ac1.ac1.service.FanServiceImpl;

public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FanDTO dto = new FanDTO();
		dto.setFanName("Preeti");
		dto.setFanColor("Brown");
		dto.setFanPrice(2000);

		FanService service = new FanServiceImpl();
		service.save(dto);

//		FanDTO dto2 = service.getFanByFanId(1);
//		System.out.println(dto2);

		// service.updatePriceByName(2, "Usha", 3000);

		// service.deleteByName(3, "Bajaj");

//		List<FanDTO> dtos = service.getAllFan();
//		dtos.forEach(System.out::println);

//		FanDTO fanDTOFromDB = service.getFanByName(2);
//		System.out.println(fanDTOFromDB);
//		
//		String cn = service.getColorByFanName("Preeti");
//		System.out.println(cn);

//		Object[] object = service.getNameAndPriceByColor("Blue");
//		for (Object object2 : object) {
//			System.out.println(object2);
//		}

//		int i = service.updatePriceByName("Usha", 5000.00);
//		System.out.println(i);
//		
//		int i = service.updateColorByName("Master", "blue");
//		System.out.println(i);

//		int k = service.deleteByName("Master");
//		System.out.println(k);
		
//		int l = service.deleteByPrice(1000.00);
//		System.out.println(l);
	}
}
