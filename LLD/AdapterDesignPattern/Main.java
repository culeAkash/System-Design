package LLD.AdapterDesignPattern;

import LLD.AdapterDesignPattern.WeightMachine.ToddlerWeightMachine;
import LLD.AdapterDesignPattern.WeightMachine.WeightMachine;
import LLD.AdapterDesignPattern.WeightMachineAdapter.ToddlerWeightMachineAdapter;

public class Main {
    public static void main(String[] args) {
        WeightMachine weightMachine = new ToddlerWeightMachine();
        ToddlerWeightMachineAdapter toddlerWeightMachineAdapter = new ToddlerWeightMachineAdapter(weightMachine);

        System.out.println(toddlerWeightMachineAdapter.getWeightInPounds());
    }
}
