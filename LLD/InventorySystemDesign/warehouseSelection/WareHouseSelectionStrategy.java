package LLD.InventorySystemDesign.warehouseSelection;

import java.util.List;

import LLD.InventorySystemDesign.WareHouse;

public interface WareHouseSelectionStrategy {
    public WareHouse selectWareHouse(List<WareHouse> wareHouses);
}
