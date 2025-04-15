package LLD.CommandDesignPattern.iComand;

import LLD.CommandDesignPattern.AirConditionerReceiver;

public class TurnOffButtonICommand implements ButtonICommand{ 
    private final AirConditionerReceiver airConditioner;

    public TurnOffButtonICommand(AirConditionerReceiver airConditionerReceiver){
        this.airConditioner = airConditionerReceiver;
    }


    public void execute(){
        airConditioner.turnOff();
    }


    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}
