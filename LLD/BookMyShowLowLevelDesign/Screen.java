package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

import LLD.BookMyShowLowLevelDesign.Seat.Seat;

public class Screen {
    int screenId;
    List<Seat> seats;

    public Screen(int screenId) {
        this.screenId = screenId;
        this.seats = new ArrayList<>();
    }
}
