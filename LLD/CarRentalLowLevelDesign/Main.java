package LLD.CarRentalLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

import LLD.CarRentalLowLevelDesign.product.Vehicle;

public class Main {
    public static void main(String[] args) {
        List<Customer> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        VehicleManagementSystem vehicleManagementSystem = new VehicleManagementSystem(vehicles);
        List<Store> stores = addStores(vehicleManagementSystem);


        StoreManagementSystem storeManagementSystem = new StoreManagementSystem(stores, users);

        // 0. User comes
        Customer customer = users.get(0);


        // 1. searches for location store
        Location location = new Location("", 0, "", "", "");
        Store store = storeManagementSystem.getStore(location);

        // 2. get all vehicles you are interested in
        List<Vehicle> interestedVehicles = store.getVehicles();

        // 3. create reservation
        Reservation reservation = store.createReservation(customer, interestedVehicles.get(0));

        // 4. generate invoice
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill, PaymentMode.ONLINE);

        //6. complete reservation
        store.completeReservation(reservation.reservationId);
                                                        
        }
                                                        
        private static List<Store> addStores(VehicleManagementSystem vehicleManagementSystem) {
            List<Store> stores = new ArrayList<>();
            Store store1 = new Store();
            store1.vehicleManagementSystem = vehicleManagementSystem;
            store1.reservations = new ArrayList<>();
            stores.add(store1);
            return stores;
        }
                                
        private static List<Vehicle> addVehicles() {
            List<Vehicle> vehicles = new ArrayList<>();
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setVehicleID(1);
            vehicles.add(vehicle1);
            return vehicles;
        }
                
        private static List<Customer> addUsers() {
            List<Customer> users = new ArrayList<>();
            Customer user1 = new Customer(1,1,1);
            user1.setUserId(1);
            users.add(user1);
            return users;
        }
}
