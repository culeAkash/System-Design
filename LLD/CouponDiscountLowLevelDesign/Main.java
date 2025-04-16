package LLD.CouponDiscountLowLevelDesign;

import LLD.CouponDiscountLowLevelDesign.product.Item;
import LLD.CouponDiscountLowLevelDesign.product.Product;
import LLD.CouponDiscountLowLevelDesign.product.ProductType;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Item("Laptop", 200, ProductType.ELECTRONICS);
        // Product product2 = new Item("Mobile", 150, ProductType.ELECTRONICS);
        Product product3 = new Item("Shirt", 50, ProductType.CLOTHES);
        Product product4 = new Item("Jeans", 100, ProductType.CLOTHES);
        // Product product5 = new Item("Washing Machine", 300, ProductType.HOME_APPLIANCES);
        // Product product6 = new Item("Refrigerator", 250, ProductType.HOME_APPLIANCES);
        Product product7 = new Item("Sugar", 50, ProductType.GROCERIES);

        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(product1);
        // cart.addToCart(product2);
        cart.addToCart(product3);
        cart.addToCart(product4);
        // cart.addToCart(product5);
        // cart.addToCart(product6);
        cart.addToCart(product7);

        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}
