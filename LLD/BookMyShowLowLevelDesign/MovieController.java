package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovies;
    List<Movie> allMovies;

    public MovieController(){
        this.cityMovies = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }


    void addMovie(Movie movie,City city){
        if(!cityMovies.containsKey(city)){
            cityMovies.put(city,new ArrayList<>());
        }
        cityMovies.get(city).add(movie);
        allMovies.add(movie);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie : allMovies){
            if(movie.movieName.equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city){
        return cityMovies.get(city);
    }
}
