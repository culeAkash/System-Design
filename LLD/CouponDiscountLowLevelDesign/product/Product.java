package LLD.CouponDiscountLowLevelDesign.product;

public abstract class Product {
    protected String name;
    protected double price;
    protected ProductType productType;

    public Product(){}

    public Product(String name, double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public ProductType getProductType() {
        return productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
