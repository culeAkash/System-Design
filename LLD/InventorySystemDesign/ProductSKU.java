package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;

public class ProductSKU {
    private int productSkuId;
    private String productCode;
    private String productDescription;
    private double price;
    private int quantity;
    private List<Product> products;

    public ProductSKU() {
        this.products = new ArrayList<>();
    }

    
    public ProductSKU(int productSkuId, String productCode, String productDescription, double price) {
        this.productSkuId = productSkuId;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = 0;
        this.products = new ArrayList<>();
    }
    public int getProductSkuId() {
        return productSkuId;
    }
    public void setProductSkuId(int productSkuId) {
        this.productSkuId = productSkuId;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.quantity++;
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.quantity--;
        this.products.remove(product);
    }

    public String toString() {
        return "ProductSKU{" +
                "productSkuId=" + productSkuId +
                ", productCode='" + productCode + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", products=" + products +
                '}';
    }
}
