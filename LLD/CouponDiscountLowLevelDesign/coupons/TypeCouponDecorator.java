package LLD.CouponDiscountLowLevelDesign.coupons;

import java.util.ArrayList;
import java.util.List;

import LLD.CouponDiscountLowLevelDesign.product.Product;
import LLD.CouponDiscountLowLevelDesign.product.ProductType;

public class TypeCouponDecorator extends CouponDecorator {
    Product product;
    int discountPercentage;
    List<ProductType> allowedTypes;

    public TypeCouponDecorator(Product product, int discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.allowedTypes = new ArrayList<>();
        this.allowedTypes.add(ProductType.ELECTRONICS);
        this.allowedTypes.add(ProductType.HOME_APPLIANCES);
    }

    @Override
    public double getPrice() {
        if(allowedTypes.contains(product.getProductType())){
            return product.getPrice() - (product.getPrice() * discountPercentage / 100);
        } else {
            return product.getPrice();
        }
    }
    
}
