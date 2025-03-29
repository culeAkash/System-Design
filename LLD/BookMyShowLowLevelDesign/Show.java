package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeats;
    public Show(int showId, Movie movie, Screen screen, int startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();
    }
}
