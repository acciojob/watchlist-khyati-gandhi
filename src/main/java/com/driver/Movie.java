package com.driver;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Movie {
	private String name;
	private int durationInMinutes;
	private double imdbRating;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public Movie(String name, int durationInMinutes, double imdbRating,int id) {
		super();
		this.name = name;
		this.durationInMinutes = durationInMinutes;
		this.imdbRating = imdbRating;
		this.id = id ;
	}
	 
	 
		
		 public Movie() { 
		 //this.id = 1;
		 //this.id = this.id+1;
	}
	

}
