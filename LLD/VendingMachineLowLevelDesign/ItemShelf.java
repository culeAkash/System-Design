package LLD.VendingMachineLowLevelDesign;

public class ItemShelf {
    public Item item;
    public int quantity;
    public int shelfCode;

    public ItemShelf(int shelfCode) {
        this.shelfCode = shelfCode;
    }

    public ItemShelf(Item item, int quantity, int shelfCode) {
        this.item = item;
        this.quantity = quantity;
        this.shelfCode = shelfCode;
    }
}
