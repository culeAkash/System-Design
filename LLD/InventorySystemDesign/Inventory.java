package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private int inventoryId;
    private List<ProductSKU> productSKUs;

    public Inventory() {
        this.productSKUs = new ArrayList<>();
    }

    public Inventory(int inventoryId) {
        this.inventoryId = inventoryId;
        this.productSKUs = new ArrayList<>();
    }
    public int getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
    public List<ProductSKU> getProductSKUs() {
        return productSKUs;
    }
    public void setProductSKUs(List<ProductSKU> productSKUs) {
        this.productSKUs = productSKUs;
    }

    public void addProduct(ProductSKU productSKU) {
        this.productSKUs.add(productSKU);
    }

    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", productSKUs=" + productSKUs +
                '}';
    }

    

}
