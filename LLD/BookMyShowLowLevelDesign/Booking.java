package LLD.BookMyShowLowLevelDesign;

import java.util.List;

import LLD.BookMyShowLowLevelDesign.Seat.Seat;

public class Booking {
    int bookingId;
    List<Seat> selectedSeats;
    Show show;
    BookingStatus status;
    Payment payment;
}

enum BookingStatus{
    BOOKED,
    CANCELLED,
}
