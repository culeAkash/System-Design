package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatres;
    List<Theatre> allTheatres;

    public TheatreController(){
        this.cityTheatres = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre1, City city) {
        if(!cityTheatres.containsKey(city)){
            cityTheatres.put(city,new ArrayList<>());
        }
        cityTheatres.get(city).add(theatre1);
        allTheatres.add(theatre1);
    }

    public Map<Theatre,List<Show>> getAllShows(Movie movie,City city){
        Map<Theatre, List<Show>> shows = new HashMap<>();
        List<Theatre> theatres = cityTheatres.get(city);

        for(Theatre theatre : theatres){
            List<Show> theatreShows = theatre.shows;
            List<Show> movieShows = new ArrayList<>();
            for(Show show : theatreShows){
                if(show.movie.movieId == movie.movieId){
                    movieShows.add(show);
                }
            }
            if(!movieShows.isEmpty()){
                shows.put(theatre,movieShows);
            }
        }
        return shows;
    }
}
