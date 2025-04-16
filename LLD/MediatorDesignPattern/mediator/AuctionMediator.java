package LLD.MediatorDesignPattern.mediator;

import LLD.MediatorDesignPattern.bidder.Colleague;

public interface AuctionMediator {
    public void placeBid(Colleague colleague, int amount);
    public void addBidder(Colleague colleague);
}
