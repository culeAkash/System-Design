package LLD.VendingMachineLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<ItemShelf> itemShelves;

    public Inventory(int noOfShelves) {
        itemShelves = new ArrayList<>();
        int startCode = 101;
        for (int i = 0; i < noOfShelves; i++) {
            ItemShelf itemShelf = new ItemShelf(startCode);
            itemShelf.quantity = 0;
            itemShelves.add(itemShelf);
            startCode++;
        }
    }
}
