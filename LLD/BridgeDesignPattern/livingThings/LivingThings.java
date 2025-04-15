package LLD.BridgeDesignPattern.livingThings;

import LLD.BridgeDesignPattern.breathingImpls.BreathingProcess;

public class LivingThings {

    BreathingProcess breathingProcess;

    public LivingThings(BreathingProcess breathingProcess) {
        this.breathingProcess = breathingProcess;
    }

    public void breathingProcess(){
        breathingProcess.breath();
    }
}