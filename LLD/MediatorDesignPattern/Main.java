package LLD.MediatorDesignPattern;

import LLD.MediatorDesignPattern.bidder.Bidder;
import LLD.MediatorDesignPattern.bidder.Colleague;
import LLD.MediatorDesignPattern.mediator.Auction;
import LLD.MediatorDesignPattern.mediator.AuctionMediator;

public class Main {
    public static void main(String[] args) {
        AuctionMediator mediator = new Auction();
        Colleague bidder1 = new Bidder("Bidder 1", mediator);
        Colleague bidder2 = new Bidder("Bidder 2", mediator);

        mediator.placeBid(bidder1, 100);
        mediator.placeBid(bidder2, 200);
        mediator.placeBid(bidder1, 300);
    }
}
