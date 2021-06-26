package com.xworkz.serial.serial.service;

import java.util.List;

import com.xworkz.serial.serial.dao.MovieDAO;
import com.xworkz.serial.serial.dao.MovieDAOImpl;
import com.xworkz.serial.serial.dto.MovieDTO;

public class MovieServiceImpl implements MovieService{
private MovieDAO mDAO;
	
	public MovieServiceImpl() {
		mDAO = new MovieDAOImpl();
	}
	
	@Override
	public void valideAndSave(MovieDTO movieDTO) {
		// TODO Auto-generated method stub
		if (movieDTO != null) {
			mDAO.save(movieDTO);
		} else {
			System.out.println("object cant be empty");
		}
	}

	@Override
	public MovieDTO validateAndGetById(int id) {
		if (id > 0) {
			return mDAO.getMovieName(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;
	
	}

	@Override
	public void validateAndUpdateRatingByName(int id, String name, int rating) {
		// TODO Auto-generated method stub
		if (name != null) {
			mDAO.updateRatingByName(id, name, rating);
		} else {
			System.out.println("Name cannot be null");
		}
	}

	@Override
	public void validateAndDelete(int id, String name) {
		if (name != null) {
			mDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}

		
	}

	@Override
	public List<MovieDTO> getAllMovies() {
		return mDAO.getAllMovies();
	}

	@Override
	public MovieDTO getMovieByMovieId(int id) {
		if(id>0) {
			return mDAO.getMovieByMovieId(id);
		}
		return null;
	}

	@Override
	public String getMovieLanguageByMovieName(String movieName) {

		if(movieName != null) {
			return mDAO.getMovieLanguageByMovieName(movieName);
		}
		return null;
	}

	@Override
	public Object[] getNameAndRatingByLanguage(String language) {
		if(language != null) {
			return mDAO.getNameAndRatingByLanguage(language);
		}
		return null;
	}

	@Override
	public List<Object[]> getAllNameAndRatingByLanguage() {
		// TODO Auto-generated method stub
		return mDAO.getNameAndRatingByLanguage();
	}

	@Override
	public int updateLanguageByName(String language, String name) {
		if(language != null && name != null) {
			return mDAO.updateLanguageByName(language,name);
		}
		return 0;
	}

	@Override
	public int updateRatingByName(int rating, String name) {
		if(rating >0 && name != null) {
			return mDAO.updateRatingByName(rating,name);
		}
		return 0;
	}

	@Override
	public int deleteMovieByLanguage(String language) {
		if(language != null) {
			return mDAO.deleteMovieByLanguage(language);
		}
		return 0;
	}

}
