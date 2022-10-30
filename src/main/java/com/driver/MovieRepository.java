package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@Repository
public class MovieRepository {
	
	
	
	private List<Movie> list = new ArrayList<Movie>();
	private List<Director> Dlist = new ArrayList<Director>();
	HashMap<String, List<String>> directorsAndMoviesMap = new HashMap<>();
	
	  public List<Director> getDlist() {
		return Dlist;
	}

	public void setDlist(List<Director> dlist) {
		Dlist = dlist;
	}
	
	

	public List<Movie> getList() {
		return list;
	}

	public void setList(List<Movie> list) {
		this.list = list;
	}

	public List<Movie> getAllMovies() {
	        return list;
	    }
	
	  
	  public Movie findByMovieId(int id){
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).getId() == (id)) {
	                return list.get(i);
	            }
	        }
	        return null;
	    }
	  
	  public Movie save(Movie p) {
		  Movie Movie = new Movie();
		 Movie.setId(p.getId());
		  Movie.setName(p.getName());
		  Movie.setDurationInMinutes(p.getDurationInMinutes());
		  Movie.setImdbRating(p.getImdbRating());;
	        list.add(Movie);
	        return Movie;
	    }
	  
	  public String delete(Integer id) {
	        list.removeIf(x -> x.getId() == (id));
	        return null;
	    }
	  
	  public Movie update(Movie Movie) {
      int idx = 0;
      int id = 0;
      for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getId() == (Movie.getId())) {
              id = Movie.getId();
              idx = i;
              break;
          }
      }

      Movie movie = new Movie();
      movie.setId(id);
      movie.setName(Movie.getName());
      movie.setDurationInMinutes(Movie.getDurationInMinutes());
      movie.setImdbRating(Movie.getImdbRating());
      list.set(idx, Movie);
      return movie;
  }

	public Director savedirector(Director director) {
		// TODO Auto-generated method stub
		Director d = new Director();
		d.setName(director.getName());
		d.setNumberOfMovies(director.getNumberOfMovies());
		d.setImdbRating(director.getImdbRating());
		return d;
	}

	public ResponseEntity findByMovieName(String name) {
		// TODO Auto-generated method stub
		
		for(Movie m :list) {
			if(m.getName() == name) {
				return new ResponseEntity<>(m,HttpStatus.OK);
			}
			
		}
		 return new ResponseEntity<>("No book found", HttpStatus.BAD_GATEWAY);
	        
	}

	public Object findByMovieDirectorName(String name) {
		// TODO Auto-generated method stub
		for( Director d :Dlist) {
			if(d.getName() == name);{
				return new ResponseEntity<>(d,HttpStatus.OK);
			}
		}
		 return new ResponseEntity<>("No book found", HttpStatus.BAD_GATEWAY);
	}
	
	
	
	
//for put hash map 
	void addMovieAndDirectors(String movieName, String directorName){
        List<String> movieList;

        if(directorsAndMoviesMap.containsKey(directorName))
            movieList = directorsAndMoviesMap.get(directorName);
        else {
            movieList = new ArrayList<>();
        }

        movieList.add(movieName);
        directorsAndMoviesMap.put(directorName, movieList);
    }
	
	List<String> getMoviesByDirector(String directorName){
        return directorsAndMoviesMap.get(directorName);
    }
	
	//still
	
	
	void deleteDirector(String director) {
		Dlist.remove(director);
        List<String> movieList = directorsAndMoviesMap.remove(director);

        for(String movie : movieList) {
        	list.remove(movie);
        }
    }
	
	
	
	
	

}
