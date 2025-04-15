package LLD.InventorySystemDesign;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.initialize();

        // see all products
        app.displayAllProducts();

        // add product to cart
        app.addToCart(1,3);

        // create order
        app.createOrder(1);

        // see all orders
        app.showAllOrders();

        //make payment
        app.makePayment();

        app.showAllOrders();
    }
}
