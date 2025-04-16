package LLD.MediatorDesignPattern.bidder;

import LLD.MediatorDesignPattern.mediator.AuctionMediator;

public class Bidder implements Colleague {
    private String name;
    private AuctionMediator mediator;


    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.addBidder(this);
    }


    public void placeBid(int amount) {
        this.mediator.placeBid(this, amount);
    }

    public String getName() {
        return name;
    }

    public void receiveNotification(int amount, String bidderName) {
        System.out.println(this.name + " received notification from " + bidderName + " for amount " + amount);
    }
    
}
