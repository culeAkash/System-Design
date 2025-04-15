package LLD.CommandDesignPattern;

public class AirConditionerReceiver {
    boolean isOn;
    int temperature;

    public void turnOn() {
        System.out.println("Air conditioner turned on");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Air conditioner turned off");
        isOn = false;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
