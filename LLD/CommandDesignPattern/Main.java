package LLD.CommandDesignPattern;

import LLD.CommandDesignPattern.iComand.TurnOffButtonICommand;
import LLD.CommandDesignPattern.iComand.TurnOnButtonICommand;

public class Main {
    public static void main(String[] args) {
        AirConditionerReceiver airConditionerReceiver = new AirConditionerReceiver();

        RemoteInvoker remoteInvoker = new RemoteInvoker();
        remoteInvoker.add(new TurnOnButtonICommand(airConditionerReceiver));
        remoteInvoker.add(new TurnOffButtonICommand(airConditionerReceiver));
        remoteInvoker.pressButton(0);
        remoteInvoker.pressButton(1);
        remoteInvoker.undo();
    }
}