package LLD.AdapterDesignPattern.WeightMachineAdapter;

import LLD.AdapterDesignPattern.WeightMachine.WeightMachine;

public class ToddlerWeightMachineAdapter implements WeightMachineAdapter {

    WeightMachine weightMachine;

    public ToddlerWeightMachineAdapter(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInPounds() {
        double weightInKg = weightMachine.getWeight();

        double weightInPounds = weightInKg * 2.20462;
        return weightInPounds;
    }
    
}
