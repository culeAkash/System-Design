package LLD.ObserverPattern.NotifyMeExample.Observer;

import LLD.ObserverPattern.NotifyMeExample.Observable.StocksObservable;

public class EmailStocksObserver implements StocksObserver {
    private String email;
    private StocksObservable observable;

    public EmailStocksObserver(String email, StocksObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Sending email to " + email + " that stock count has changed");
        observable.getStockCount();
    }
}
