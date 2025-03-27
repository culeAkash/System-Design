package LLD.CarRentalLowLevelDesign;

import java.util.List;

public class StoreManagementSystem {
    List<Customer> customers;
    List<Store> stores;

    StoreManagementSystem(List<Store> stores, List<Customer> users) {

        this.stores = stores;
        this.customers = users;
    }


    public Store getStore(Location location){
        //based on location, we will filter out the Store from storeList.
        return stores.get(0);
    }

    // add store
    //remove store
    // add customer
    //delete customer

}
