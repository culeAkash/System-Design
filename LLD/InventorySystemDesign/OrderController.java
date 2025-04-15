package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderController {
    private List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void createOrder(Cart cart, User user, WareHouse wareHouse) {
        Invoice invoice  = new Invoice(1,0);
        Order order = new Order(1,user,wareHouse,wareHouse.getAddress(),invoice,cart.getSkuIdCountMap());
        user.getOrderIds().add(order.getOrderId());
        this.orders.add(order);
        System.out.println("Order created successfully");
    }

    public void makePayment(Order order, User user, PaymentMode mode) {
        int amount = 0;
        for(Map.Entry<Integer,Integer> entry : order.getSkuIdCountMap().entrySet()){
            ProductSKU productSKU = order.getWarehouse().getInventory().getProductSKUs().stream()
            .filter(productSku -> productSku.getProductSkuId() == entry.getKey())
            .findFirst().get();
            amount += productSKU.getPrice() * entry.getValue();
        }
        Payment payment = new Payment(1,amount,mode);

        order.addPaymentDetails(payment, PaymentStatus.PAID);

        System.out.println("Payment made successfully");
    }
}
