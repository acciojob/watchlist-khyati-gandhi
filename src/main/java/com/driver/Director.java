package com.driver;

public class Director {
	private String name;
	
	private int numberOfMovies;
	
	private double imdbRating;
	
	private int id ;
	
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

	public int getNumberOfMovies() {
		return numberOfMovies;
	}

	public void setNumberOfMovies(int numberOfMovies) {
		this.numberOfMovies = numberOfMovies;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Director(String name, int numberOfMovies, double imdbRating,int id) {
		super();
		this.name = name;
		this.numberOfMovies = numberOfMovies;
		this.imdbRating = imdbRating;
		this.id = id; 
	}
	
	Director(){};
	



}
