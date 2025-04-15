package LLD.InventorySystemDesign;

public class WareHouse {
    private int warehouseId;
    private Address address;
    private Inventory inventory;

    public WareHouse(int warehouseId,Address address){
        this.warehouseId = warehouseId;
        this.address = address;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }



    @Override
    public String toString() {
        return "WareHouse [warehouseId=" + warehouseId + ", address=" + address + ", inventoryList=" + inventory
                + "]";
    }

    

    


}
