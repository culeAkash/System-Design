package LLD.InventorySystemDesign.warehouseSelection;

import java.util.List;

import LLD.InventorySystemDesign.WareHouse;

public class DistanceBasedWareHouseSelectionStrategy implements WareHouseSelectionStrategy{

    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouses) {
        return wareHouses.get(1);
    }
    
}
