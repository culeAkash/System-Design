package LLD.ObserverPattern.WeatherObservableExample;

import java.util.List;

public class WeatherStationObservable implements Observable {
    private String data;
    List<Observer> observers;

    public WeatherStationObservable() {
        observers = new java.util.ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    @Override
    public void setData(String data) {
        this.data = data;
        notifyObservers();
    }
    @Override
    public void getData() {
        System.out.println("Current weather data: " + data);
    }

    
    
}
