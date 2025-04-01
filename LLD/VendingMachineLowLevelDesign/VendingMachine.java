package LLD.VendingMachineLowLevelDesign;

import java.util.ArrayList;
import java.util.List;

import LLD.VendingMachineLowLevelDesign.state.State;
import LLD.VendingMachineLowLevelDesign.state.impl.IdleState;

public class VendingMachine {
    public State vendingMachineState;
    public List<Coin> coinsInserted;
    public Inventory inventory;

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.coinsInserted = new ArrayList<>();
        this.inventory = new Inventory(10);
    }

}
