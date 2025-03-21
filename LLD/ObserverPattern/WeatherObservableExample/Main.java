package LLD.ObserverPattern.WeatherObservableExample;

public class Main {
    public static void main(String[] args) {

        Observable weatherObservable = new WeatherStationObservable();
        Observable cricketScoreObservable = new CricketScoreObservable();

        new TvDisplayObserver(weatherObservable);
        new MobileDisplayObserver(weatherObservable);

        new TvDisplayObserver(cricketScoreObservable);
        new MobileDisplayObserver(cricketScoreObservable);

        weatherObservable.setData("27 C");

        cricketScoreObservable.setData("India vs Australia");
    }
}
