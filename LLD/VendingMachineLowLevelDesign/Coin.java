package LLD.VendingMachineLowLevelDesign;

public enum Coin {
    PENNY(1),
    QUARTER(25),
    DIME(10),
    NICKEL(5);

    private int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
