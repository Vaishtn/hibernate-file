package com.xworkz.serial.serial;

import com.xworkz.serial.serial.dto.MovieDTO;
import com.xworkz.serial.serial.service.MovieService;
import com.xworkz.serial.serial.service.MovieServiceImpl;

public class Tester {
	public static void main(String[] args) {

		MovieDTO dto = new MovieDTO();
		dto.setMovieName("Roberrt");
		dto.setLanguage("telugu");
		dto.setMovieRating(4);
		dto.setReleaseDate(2021);

		MovieService service = new MovieServiceImpl();
//		service.valideAndSave(dto);
		
//		MovieDTO dto1 = service.validateAndGetById(3);
//		System.out.println(dto1);
		
//		service.validateAndUpdateRatingByName(4, "Ala Vaikunthapurramuloo", 4);
//		service.validateAndDelete(2, "Roberrt");
		
//		List<MovieDTO> dtos = service.getAllMovies();
//		dtos.forEach(System.out::println);
		
		
//		MovieDTO movieDTOFromDB = service.getMovieByMovieId(4);
//		System.out.println(movieDTOFromDB);
		
//		String language = service.getMovieLanguageByMovieName("KGF");
//		System.out.println(language);
//		
//		Object[] object = service.getNameAndRatingByLanguage("English");
//		for (Object object2 : object) {
//			System.out.println(object2);
//		}
//		
//		List<Object[]> list = service.getAllNameAndRatingByLanguage();
//		for (Object[] objects : list) {
//			for (Object objects2 : objects) {
//				System.out.println(objects2);
//			}
//		}
		
//		int i = service.updateLanguageByName("Kannada", "Roberrt");
//		System.out.println(i);
		
//		int j = service.updateRatingByName(5, "Roberrt");
//		System.out.println(j);
	
//		int k = service.deleteMovieByLanguage("telugu");
//		System.out.println(k);
		
		
	}
}
