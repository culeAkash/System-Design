package LLD.InventorySystemDesign;

public class Address {
    private int addressId;
    private String street;
    private String city;
    private String state;
    private String country;
    private int pincode;

    public Address(int addressId, String street, String city, String state, String country, int pincode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
                + ", country=" + country + ", pincode=" + pincode + "]";
    }


    
}
