package LLD.ObserverPattern.NotifyMeExample.Observable;

import LLD.ObserverPattern.NotifyMeExample.Observer.StocksObserver;

public interface StocksObservable {
    public void register(StocksObserver observer);
    public void remove(StocksObserver observer);
    public void notifyAllSubscribers();
    public void setStockCount(int stockCount);
    public void getStockCount();
}
