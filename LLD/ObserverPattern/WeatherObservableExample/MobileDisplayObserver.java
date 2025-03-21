package LLD.ObserverPattern.WeatherObservableExample;

public class MobileDisplayObserver implements Observer {
    private Observable observable;

    public MobileDisplayObserver(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Updating mobile display");
        observable.getData();
    }
    
}
