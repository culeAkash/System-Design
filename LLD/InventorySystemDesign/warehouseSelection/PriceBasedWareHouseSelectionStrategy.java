package LLD.InventorySystemDesign.warehouseSelection;

import java.util.List;

import LLD.InventorySystemDesign.WareHouse;

public class PriceBasedWareHouseSelectionStrategy implements WareHouseSelectionStrategy {

    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouses) {
        return wareHouses.get(0);
    }
    
}
