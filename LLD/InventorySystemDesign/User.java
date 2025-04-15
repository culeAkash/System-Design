package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private Cart cart;
    private List<Integer> orderIds;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.cart = new Cart(userId);
        this.orderIds = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", cart=" + cart + ", orderIds=" + orderIds + "]";
    }

    
}
