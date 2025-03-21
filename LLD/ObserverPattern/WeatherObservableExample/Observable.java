package LLD.ObserverPattern.WeatherObservableExample;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setData(String data);
    void getData();
}
