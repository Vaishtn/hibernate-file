package com.xworkz.serial.serial.service;

import java.util.List;

import com.xworkz.serial.serial.dto.MovieDTO;

public interface MovieService {
	void valideAndSave(MovieDTO movieDTO);

	public MovieDTO validateAndGetById(int id);

	public void validateAndDelete(int id, String name);

	void validateAndUpdateRatingByName(int id, String name, int rating);

	public List<MovieDTO> getAllMovies();

	public MovieDTO getMovieByMovieId(int id);

	public String getMovieLanguageByMovieName(String movieName);

	public Object[] getNameAndRatingByLanguage(String language);

	public List<Object[]> getAllNameAndRatingByLanguage();

	public int updateLanguageByName(String language, String name);

	public int updateRatingByName(int rating, String name);

	public int deleteMovieByLanguage(String language);
}
