package LLD.InventorySystemDesign;

import java.util.Map;

public class Order {
    private int orderId;
    private User user;
    private Payment payment;
    private PaymentStatus paymentStatus;
    private Invoice invoice;
    private WareHouse warehouse;
    private Map<Integer,Integer> skuIdCountMap;
    private Address address;
    private OrderStatus orderStatus;

    public Order(int orderId,User user,WareHouse warehouse,Address address,Invoice invoice,Map<Integer,Integer> skuIdCountMap) {
        this.orderId = orderId;
        this.user = user;
        this.warehouse = warehouse;
        this.address = address;
        this.invoice = invoice;
        this.skuIdCountMap = skuIdCountMap;
        this.orderStatus = OrderStatus.PLACED;
        this.paymentStatus = PaymentStatus.UNPAID;
    }

    public void addPaymentDetails(Payment payment,PaymentStatus paymentStatus) {
        this.payment = payment;
        this.paymentStatus = paymentStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public WareHouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public Map<Integer, Integer> getSkuIdCountMap() {
        return skuIdCountMap;
    }

    public void setSkuIdCountMap(Map<Integer, Integer> skuIdCountMap) {
        this.skuIdCountMap = skuIdCountMap;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", user=" + user + ", payment=" + payment + ", paymentStatus="
                + paymentStatus + ", invoice=" + invoice + ", warehouse=" + warehouse + ", skuIdCountMap="
                + skuIdCountMap + ", address=" + address + ", orderStatus=" + orderStatus + "]";
    }


    
    


}
