package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;

import LLD.InventorySystemDesign.warehouseSelection.WareHouseSelectionStrategy;

public class WareHouseController {
    List<WareHouse> wareHouses;
    WareHouseSelectionStrategy wareHouseSelectionStrategy;

    public WareHouseController(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouses = new ArrayList<>();
        this.wareHouseSelectionStrategy = wareHouseSelectionStrategy;
    }

    public void addWareHouse(WareHouse wareHouse) {
        this.wareHouses.add(wareHouse);
    }

    public void removeWareHouse(WareHouse wareHouse) {
        this.wareHouses.remove(wareHouse);
    }

    public WareHouse getWareHouse() {
        return wareHouseSelectionStrategy.selectWareHouse(wareHouses);
    }
}
