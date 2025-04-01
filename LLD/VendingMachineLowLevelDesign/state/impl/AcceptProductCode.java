package LLD.VendingMachineLowLevelDesign.state.impl;

import LLD.VendingMachineLowLevelDesign.Coin;
import LLD.VendingMachineLowLevelDesign.ItemShelf;
import LLD.VendingMachineLowLevelDesign.VendingMachine;
import LLD.VendingMachineLowLevelDesign.state.State;

public class AcceptProductCode implements State {

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        System.out.println("Cancel button pressed, full refund in given and vending machine goes to idle state");
        vendingMachine.vendingMachineState = new IdleState();
        for(Coin coin : vendingMachine.coinsInserted){
            System.out.printf("Coin %s returned\n",coin.getValue());
            vendingMachine.coinsInserted.remove(coin);
        }  
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void pressSelectproductButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressSelectproductButton'");
    }

    @Override
    public void enterProductCodeButton(VendingMachine vendingMachine, int shelfCode) throws Exception {
        ItemShelf itemShelf = null;
        int totalAmountPaid = 0;
        for(Coin coin : vendingMachine.coinsInserted){
            totalAmountPaid += coin.getValue();
        }
        for(ItemShelf itemShelf1 : vendingMachine.inventory.itemShelves){
            if(itemShelf1.shelfCode == shelfCode){
                itemShelf = itemShelf1;
                break;
            }
        }
        if(itemShelf != null){
            if(itemShelf.quantity == 0){
                throw new Exception("Item not available");
            }
            else if(totalAmountPaid < itemShelf.item.price){
                throw new Exception("Insufficient amount paid");
            }
            else{
                int change = totalAmountPaid - itemShelf.item.price;
                if(change > 0){
                    getChange(vendingMachine,change);
                }
                System.out.printf("Item %s going to be dispensed\n",itemShelf.item.itemType);
                vendingMachine.coinsInserted.clear();
                System.out.println("Change state to dispense change");
                vendingMachine.vendingMachineState = new DispenseProductState();
            }            
        }
        else{
            throw new Exception("No shelf found");
        }
        
    }

    private void getChange(VendingMachine vendingMachine, int change) {
        System.out.printf("%s is given back to customer",change);        
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressCancelButton'");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine,int shelfCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseProduct'");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseChange'");
    }
    
}
