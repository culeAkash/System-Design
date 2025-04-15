package LLD.InventorySystemDesign;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int cartId;
    private Map<Integer,Integer> skuIdCountMap;

    public Cart(int cartId) {
        this.cartId = cartId;
        this.skuIdCountMap = new HashMap<>();
    }

    public int getCartId() {
        return cartId;
    }

    public Map<Integer, Integer> getSkuIdCountMap() {
        return skuIdCountMap;
    }

    public void addItem(int skuId,int count){
        skuIdCountMap.put(skuId,count);
    }

    public void removeItem(int skuId){
        skuIdCountMap.remove(skuId);
    }
}
