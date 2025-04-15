package LLD.BridgeDesignPattern;

import LLD.BridgeDesignPattern.breathingImpls.LandBreathingProcess;
import LLD.BridgeDesignPattern.breathingImpls.TreeBreathingProcess;
import LLD.BridgeDesignPattern.breathingImpls.WaterBreathingProcess;
import LLD.BridgeDesignPattern.livingThings.Dog;
import LLD.BridgeDesignPattern.livingThings.Fish;
import LLD.BridgeDesignPattern.livingThings.LivingThings;
import LLD.BridgeDesignPattern.livingThings.Tree;

public class Main {
    public static void main(String[] args) {
        LivingThings dogObj = new Dog(new LandBreathingProcess());
        dogObj.breathingProcess();

        LivingThings fishObj = new Fish(new WaterBreathingProcess());
        fishObj.breathingProcess();

        LivingThings treeObj = new Tree(new TreeBreathingProcess());
        treeObj.breathingProcess();
    }   
}
