package LLD.VendingMachineLowLevelDesign;

import LLD.VendingMachineLowLevelDesign.state.State;

public class Main{
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");


            fillVendingMachine(vendingMachine,10);
            displayInventory(vendingMachine);
            
            State vendingMachineState = vendingMachine.vendingMachineState;

            System.out.println("|");
            System.out.println("Clicking on Insert cash button");
            System.out.println("|");
            vendingMachineState.pressInsertCashButton(vendingMachine);
            
            vendingMachineState = vendingMachine.vendingMachineState;
            vendingMachineState.insertCoin(vendingMachine, Coin.PENNY);
            vendingMachineState.insertCoin(vendingMachine, Coin.QUARTER);
            vendingMachineState.insertCoin(vendingMachine, Coin.DIME);
            // vendingMachineState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("Clicking on Select product button");
            System.out.println("|");
            vendingMachineState.pressSelectproductButton(vendingMachine);

            vendingMachineState = vendingMachine.vendingMachineState;
            vendingMachineState.enterProductCodeButton(vendingMachine, 110);

            vendingMachineState = vendingMachine.vendingMachineState;

            vendingMachineState.dispenseProduct(vendingMachine,110);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        Inventory inventory = vendingMachine.inventory;
        for(ItemShelf itemShelf : inventory.itemShelves){
            System.out.println("|");
            System.out.println(itemShelf.item.itemType);
            System.out.println(itemShelf.quantity);
            System.out.println(itemShelf.item.price);
            System.out.println(itemShelf.shelfCode);
            System.out.println("|");
        }
    }

    private static void fillVendingMachine(VendingMachine vendingMachine, int noOfShelves) {
        Inventory inventory = vendingMachine.inventory;
        for (int i = 0; i < noOfShelves; i++) {
            Item item = new Item();
            if(i>=0 && i<3){
                item.price = 10;
                item.itemType = ItemType.CHIPS;
            }
            else if(i>=3 && i<6){
                item.price = 20;
                item.itemType = ItemType.COKE;
            }
            else if(i>=6 && i<9){
                item.price = 30;
                item.itemType = ItemType.PEPSI;
            }
            else{
                item.price = 40;
                item.itemType = ItemType.CHOCOLATE;
            }
            inventory.itemShelves.get(i).item = item;
            inventory.itemShelves.get(i).quantity = 10;
        }
    }
}