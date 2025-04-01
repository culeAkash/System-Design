package LLD.VendingMachineLowLevelDesign.state;

import LLD.VendingMachineLowLevelDesign.Coin;
import LLD.VendingMachineLowLevelDesign.VendingMachine;

public interface State {
    void pressInsertCashButton(VendingMachine vendingMachine);

    void insertCoin(VendingMachine vendingMachine,Coin coin);

    void pressSelectproductButton(VendingMachine vendingMachine);

    void enterProductCodeButton(VendingMachine vendingMachine,int shelfCode) throws Exception;

    void pressCancelButton(VendingMachine vendingMachine);

    void dispenseProduct(VendingMachine vendingMachine,int shelfCode);

    void dispenseChange(VendingMachine vendingMachine);
}
