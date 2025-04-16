package LLD.MediatorDesignPattern.mediator;

import java.util.ArrayList;
import java.util.List;
import LLD.MediatorDesignPattern.bidder.Colleague;

public class Auction implements AuctionMediator{
    List<Colleague> bidders;

    public Auction() {
        this.bidders = new ArrayList<>();
    }

    public void addBidder(Colleague bidder) {
        this.bidders.add(bidder);
    }

    public void placeBid(Colleague bidder, int amount) {
        for(Colleague b : bidders){
            if(!b.getName().equals(bidder.getName())){
                b.receiveNotification(amount, bidder.getName());
            }
        }
    }
}
