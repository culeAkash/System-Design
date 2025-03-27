package LLD.CarRentalLowLevelDesign;

import java.util.List;

import LLD.CarRentalLowLevelDesign.product.Vehicle;

public class Store {
    VehicleManagementSystem vehicleManagementSystem;
    Location location;
    List<Reservation> reservations;


    public List<Vehicle> getVehicles() {
        return vehicleManagementSystem.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        
        for(Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicleManagementSystem.addVehicle(vehicle);
        }
    }

    public Reservation createReservation(Customer customer, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReservation(customer, vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        Reservation reservation = null;
        for(Reservation res : reservations) {
            if(res.reservationId == reservationId) {
                reservation = res;
                break;
            }
        }
        if(reservation != null) {
            reservation.reservationStatus = ReservationStatus.COMPLETED;
            return true;
        }
        return false;
    }
}
