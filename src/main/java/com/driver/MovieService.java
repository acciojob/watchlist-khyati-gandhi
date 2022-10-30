package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	private ResponseEntity findByMovieName;
	private Object findByMovieDirectorName;

	
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		//move.setId(move.getId()+1);
		movie.setId(movie.getId());
        
		return movieRepository.save(movie);
	}


	public Director addDirector(Director director) {
		// TODO Auto-generated method stub
		director.setId(director.getId());
		return movieRepository.savedirector(director);
		
	}

//	que 4 put 
	
	void addMovieAndDirector(String movie, String director) {
        movieRepository.addMovieAndDirectors(movie, director);
    }
	
	List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirector(directorName);
    }
//still
	public ResponseEntity findByName(String name) {
		// TODO Auto-generated method stub
		findByMovieName = movieRepository.findByMovieName(name);
		return new ResponseEntity<>(findByMovieName, HttpStatus.CREATED);
	}


	public ResponseEntity findByDirectorName(String name) {
		// TODO Auto-generated method stub
	 findByMovieDirectorName = movieRepository.findByMovieDirectorName(name);
		return new ResponseEntity<>(findByMovieDirectorName, HttpStatus.CREATED);
	}

	//del 
	
    void deleteDirectorfromlist(String director) {
        movieRepository.deleteDirector(director);
    }

	public List getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
		 
	}
	
	
	
	
	

}
