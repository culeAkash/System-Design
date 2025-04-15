package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.Optional;

import LLD.InventorySystemDesign.warehouseSelection.PriceBasedWareHouseSelectionStrategy;

public class App {

    private WareHouseController wareHouseController;
    private UserController userController;
    private OrderController orderController;

    public App startApp(){
        initialize();
        return this;
    }

    public void initialize(){
        initializeUser();
        initializeWareHouse();
        initializeOrder();
    }

    private void initializeOrder() {
        orderController = new OrderController();
    }

    private void initializeWareHouse() {
        // create warehouse
        this.wareHouseController = new WareHouseController(new PriceBasedWareHouseSelectionStrategy());
        createWareHouse();
    }

    private void createWareHouse() {
        // create inventory
        Inventory inventory = new Inventory(1);
        // create skus
        ProductSKU productSKU1 = new ProductSKU(1, "A", "Product1",10.0);
        ProductSKU productSKU2 = new ProductSKU(2, "B", "Product2",20.0);

        // create products
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        Product product3 = new Product(3, "Product3");

        // add products to skus
        productSKU1.addProduct(product3);
        productSKU2.addProduct(product2);
        productSKU1.addProduct(product1);

        inventory.addProduct(productSKU1);
        inventory.addProduct(productSKU2);

        // add inventory to warehouse
        WareHouse wareHouse = new WareHouse(1, new Address(1,"","","","",1));
        wareHouse.setInventory(inventory);
        this.wareHouseController.addWareHouse(wareHouse);
    }

    private void initializeUser() {
        User user = new User(1, "A");
        userController = new UserController();
        this.userController.addUser(user);
    }

    public void displayAllProducts() {
        // display all products from the warehouse
        WareHouse wareHouse = this.wareHouseController.getWareHouse();

        Inventory inventory = wareHouse.getInventory();
        for(ProductSKU productSKU : inventory.getProductSKUs()){
            System.out.println("Product SKU: " + productSKU.getProductSkuId() +
            ", Product Name: " + productSKU.getProductDescription() + 
            ", Product Price: " + productSKU.getPrice() +
            ", Product Quantity: " + productSKU.getQuantity()
            );
            for(Product product : productSKU.getProducts()){
                System.out.println(
                    "Product ID: " + product.getProductId() +
                    ", Product Name: " + product.getProductName()
                );
            }
        }
    }

    public void addToCart(int skuId, int productId) {
        User user = this.userController.getUsers().get(0);
        Cart cart = user.getCart();

        Optional<Product> productOptional = wareHouseController.getWareHouse().getInventory().getProductSKUs().stream()
        .filter(productSku -> productSku.getProductSkuId() == skuId)
        .flatMap(productSku -> productSku.getProducts().stream()
        .filter(product -> product.getProductId() == productId))
        .findFirst();

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            this.wareHouseController.getWareHouse().getInventory().getProductSKUs().stream()
            .filter(productSku -> productSku.getProductSkuId() == skuId)
            .forEach(productSku -> productSku.removeProduct(product));
            cart.addItem(skuId,1);
        }
        
    }

    public void createOrder(int i) {
        User user = this.userController.getUsers().get(0);
        Cart cart = user.getCart();
        this.orderController.createOrder(cart,user,this.wareHouseController.getWareHouse());
    }

    public void showAllOrders() {
        for(Order order : this.orderController.getOrders()){
            System.out.println(order);
        }
    }

    public void makePayment() {
        User user = this.userController.getUsers().get(0);
        Order order = this.orderController.getOrders().stream().filter(order1 -> order1.getUser().getUserId() == user.getUserId()).findFirst().get();
        this.orderController.makePayment(order,user,PaymentMode.UPI);
    }
}
