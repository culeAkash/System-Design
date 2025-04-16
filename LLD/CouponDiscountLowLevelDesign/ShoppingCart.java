package LLD.CouponDiscountLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

import LLD.CouponDiscountLowLevelDesign.coupons.PercentageCouponDecorator;
import LLD.CouponDiscountLowLevelDesign.coupons.TypeCouponDecorator;
import LLD.CouponDiscountLowLevelDesign.product.Product;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }


    public void addToCart(Product product) {
        Product productToCart = new PercentageCouponDecorator(new TypeCouponDecorator(product, 5), 10);
        products.add(productToCart);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product : products){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
