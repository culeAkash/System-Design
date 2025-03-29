package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatreId;
    String theatreName;
    City city;
    List<Screen> screens;
    List<Show> shows;

    public Theatre(int theatreId, String theatreName, City city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }
}