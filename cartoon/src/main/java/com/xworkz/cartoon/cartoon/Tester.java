package com.xworkz.cartoon.cartoon;

import java.util.List;

import com.xworkz.cartoon.cartoon.dto.CartoonDTO;
import com.xworkz.cartoon.cartoon.service.CartoonService;
import com.xworkz.cartoon.cartoon.service.CartoonServiceImpl;

public class Tester {
public static void main(String[] args) {
		
		CartoonDTO dto = new CartoonDTO();
		dto.setCartoonCharacterName("Mickey Mouse");
		dto.setChannelName("Disney Channel");
		dto.setRating(4);
		
		CartoonService service = new CartoonServiceImpl();
//		service.save(dto);
		
//		System.out.println("invoked getCartoonById");
//		CartoonDTO dto2 = service.getCartoonById(3);
//		System.out.println(dto2);

//		service.updateRatingByName(1, "Chota Bhim", 4);
//		
//		service.deleteByName(5, "Mickey Mouse");
		
//		System.out.println("invoked getAllCartoon");
//		List<CartoonDTO> dtos = service.getAllCartoon();
//		dtos.forEach(System.out::println);
		
//		System.out.println("invoked getCartoonByCartoonId");
//		CartoonDTO cartoonDTOFromDB = service.getCartoonByCartoonId(2);
//		System.out.println(cartoonDTOFromDB);
//		
//		System.out.println("invoked getChannelNameByCartoonCharacterName");
//		String cn = service.getChannelNameByCartoonCharacterName("Doraemon");
//		System.out.println(cn);
//		
//		System.out.println("invoked getNameAndRatingByChannelName");
//		Object[] object = service.getNameAndRatingByChannelName("POGO");
//		for (Object object2 : object) {
//			System.out.println(object2);
//		}
//		
		System.out.println("invoked getAllNameAndRatingByChannelName");
		List<Object[]> list = service.getAllNameAndRatingByChannelName("Disney Channel");
		list.forEach(System.out::println);
	}


}
