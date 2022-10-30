package com.driver;

import java.util.List;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	private int id;
	
	private int did;
	private Director addDirector;
	 
	
	
	@PostMapping("/add-movie")
	public ResponseEntity addmovie(@RequestBody Movie movie) {
	movie.setId(id);
	this.id = this.id+1;
	Movie addMovie = movieService.addMovie(movie);
	return new ResponseEntity<>(addMovie, HttpStatus.CREATED);
	}
	
//	Add a director: POST /movies/add-director
//	Pass the Director object as request body
//	Return success message wrapped in a ResponseEntity object
//	Controller Name - addDirector
	
	
	@PostMapping("/add-director")
	public ResponseEntity adddirector(@RequestBody Director director) {
		director.setId(did);
		this.did = this.did +1;
		addDirector = movieService.addDirector(director);
		return new ResponseEntity<>(addDirector, HttpStatus.CREATED);
		
	}
	
//	Pair an existing movie and director: PUT /movies/add-movie-director-pair
//	Pass movie name and director name as request parameters
//	Return success message wrapped in a ResponseEntity object
//	Controller Name - addMovieDirectorPair
	
//	@PutMapping("/add-movie-director-pair")
	//public ResponseEntity addMovieDirectorPair(){}
	
	@PutMapping("/add-movie-director-pair")
	  public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
         @RequestParam("directorsName")String directorName){
		movieService.addMovieAndDirector(movieName, directorName);

		List<String> list = movieService.getMoviesByDirectorName(directorName);
		return new ResponseEntity<>("Added Data ", HttpStatus.OK);
}
	
	
//	Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//	Pass movie name as path parameter
//	Return Movie object wrapped in a ResponseEntity object
//	Controller Name - getMovieByName
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity getMovieByName(@PathVariable String name ) {
		return movieService.findByName(name);
		 
	}
	
//	Get Director by director name: GET /movies/get-director-by-name/{name}
//	Pass director name as path parameter
//	Return Director object wrapped in a ResponseEntity object
//	Controller Name - getDirectorByName
	
	
	@GetMapping("/get-director-by-name/{name}")
	public ResponseEntity getMovieByDirectorName(@PathVariable String name ) {
		return movieService.findByDirectorName(name);
		 
	}
		
//	Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//	Pass director name as path parameter
//	Return List of movies name(List()) wrapped in a ResponseEntity object
//	Controller Name - getMoviesByDirectorName
	
	@GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

	
//	Get List of all movies added: GET /movies/get-all-movies
//	No params or body required
//	Return List of movies name(List()) wrapped in a ResponseEntity object
//	Controller Name - findAllMovies
	 
	@GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List getAllMovies = movieService.getAllMovies();
        return new ResponseEntity<>(getAllMovies, HttpStatus.OK);
    }
	
	//check in postman onece 
	

	@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director){
        movieService.deleteDirectorfromlist(director);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
	
	

	public MovieController() {
		 
		// TODO Auto-generated constructor stub
	}

	
}
