package LLD.ObserverPattern.WeatherObservableExample;

public class TvDisplayObserver implements Observer {
    private Observable observable;

    public TvDisplayObserver(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Updating TV display");
        observable.getData();
    }
}
