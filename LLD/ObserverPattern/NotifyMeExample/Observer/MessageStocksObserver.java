package LLD.ObserverPattern.NotifyMeExample.Observer;

import LLD.ObserverPattern.NotifyMeExample.Observable.StocksObservable;

public class MessageStocksObserver implements StocksObserver{
    private String mobileNumber;
    private StocksObservable observable;
    public MessageStocksObserver(String mobileNumber, StocksObservable observable) {
        this.mobileNumber = mobileNumber;
        this.observable = observable;
    }
    @Override
    public void update() {
        System.out.println("Sending message to "+mobileNumber+" that stock count has changed");
        observable.getStockCount();
    }
}
