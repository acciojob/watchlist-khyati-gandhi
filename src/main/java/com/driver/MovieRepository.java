package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class MovieRepository {

    ArrayList<Movie> list1 = new ArrayList<>();
    ArrayList<Director> list2 = new ArrayList<>();

    HashMap<Movie,Director> hm = new HashMap<>();

    public void AddMovieToDB(Movie movie)
    {
        if(!list1.contains(movie))
        {
            list1.add(movie);
        }
    }

    public void AddDirectorToDB(Director director)
    {
        if(!list2.contains(director))
        {
            list2.add(director);
        }
    }

    public void PairMovieAndDirectorToDB(String movieName, String directorName)
    {
        Movie M = null;
        Director D = null;
        for(Movie m : list1)
        {
            if(m.getName().equals(movieName))
            {
                M = m;
                break;
            }
        }
        for(Director d : list2)
        {
            if(d.getName().equals(directorName))
            {
                D = d;
                break;
            }
        }
        hm.put(M,D);
    }

    public Movie findMovieInDB(String name)
    {
        for(Movie m : list1){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public Director findDirectorInDB(String name)
    {
        for(Director d : list2)
        {
            if(d.getName().equals(name))
            {
                return d;
            }
        }
        return null;
    }

    public List<String> list1InDBByDirector(String name)
    {
        List<String> toReturn = new ArrayList<>();
        for(Movie M : hm.keySet())
        {
            if(hm.get(M).getName().equals(name))
            {
                toReturn.add(M.getName());
            }
        }
        return toReturn;
    }

    public List<String> findAllMoviesInDB()
    {
        List<String> list = new ArrayList<>();
        for(Movie m : list1){
            list.add(m.getName());
        }
        return list;
    }

    public void DeleteMovieFromDBbyName(String Dname)
    {
        Director D = null;
        for(Director d : list2)
        {
            if(d.getName().equals(Dname))
            {
                D = d;
                break;
            }
        }
        for(Movie m : hm.keySet())
        {
            if(hm.get(m) == D)
            {
                list1.remove(m);
            }
        }

    }

    public void DeleteAllMappedInDB()
    {
        for(Movie M : hm.keySet())
        {
            list1.remove(M);
        }
        for(Director D : hm.values())
        {
            list2.remove(D);
        }
        hm = new HashMap<>();
    }
}
