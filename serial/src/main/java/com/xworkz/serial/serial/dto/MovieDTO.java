package com.xworkz.serial.serial.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="movie")
public class MovieDTO implements Serializable{
@Id
	
	@Column(name="movie_id")
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	 
	@Column(name="language")
	private String language;
	
	@Column(name="movie_rating")
	private int movieRating;
	
	@Column(name="release_date")
	private int releaseDate;
	
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language
				+ ", movieRating=" + movieRating + ", releaseDate=" + releaseDate + "]";
	}

}
