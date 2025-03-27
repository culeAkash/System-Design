package LLD.CarRentalLowLevelDesign;

import java.util.Date;

import LLD.CarRentalLowLevelDesign.product.Vehicle;

public class Reservation {
    int reservationId;
    Customer customer;
    Vehicle vehicle;
    Date dateBooked;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    // create reservation
    public int createReservation(Customer customer, Vehicle vehicle) {
        reservationId = 12232;
        this.customer=customer;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }

}
