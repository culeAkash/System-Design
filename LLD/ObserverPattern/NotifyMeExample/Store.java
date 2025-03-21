package LLD.ObserverPattern.NotifyMeExample;

import LLD.ObserverPattern.NotifyMeExample.Observable.IPhoneStocksObservableImpl;
import LLD.ObserverPattern.NotifyMeExample.Observable.StocksObservable;
import LLD.ObserverPattern.NotifyMeExample.Observer.EmailStocksObserver;
import LLD.ObserverPattern.NotifyMeExample.Observer.MessageStocksObserver;
import LLD.ObserverPattern.NotifyMeExample.Observer.StocksObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable observable = new IPhoneStocksObservableImpl();

        StocksObserver messageObserver = new MessageStocksObserver("1234567890", observable);
        StocksObserver emailObserver = new EmailStocksObserver("iHxQ0@example.com", observable);

        observable.register(messageObserver);
        observable.register(emailObserver);

        observable.setStockCount(10);
        observable.setStockCount(0);
        observable.setStockCount(20);
    }
}
