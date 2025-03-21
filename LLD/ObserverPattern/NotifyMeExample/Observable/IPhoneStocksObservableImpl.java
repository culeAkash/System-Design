package LLD.ObserverPattern.NotifyMeExample.Observable;

import java.util.ArrayList;
import java.util.List;

import LLD.ObserverPattern.NotifyMeExample.Observer.StocksObserver;

public class IPhoneStocksObservableImpl implements StocksObservable {
    private List<StocksObserver> observers;
    private int stockCount;

    public IPhoneStocksObservableImpl() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(StocksObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(StocksObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllSubscribers() {
        for (StocksObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        int prevStockCount = this.stockCount;
        this.stockCount = stockCount;
        if (prevStockCount != stockCount && stockCount > 0 && prevStockCount == 0) {
            notifyAllSubscribers();
        }
    }

    @Override
    public void getStockCount() {
        System.out.println("Stock count: " + this.stockCount);
    }

    
}
