package LLD.CommandDesignPattern.iComand;

import LLD.CommandDesignPattern.AirConditionerReceiver;

public class TurnOnButtonICommand implements ButtonICommand {
    private final AirConditionerReceiver airConditioner;

    public TurnOnButtonICommand(AirConditionerReceiver airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}
