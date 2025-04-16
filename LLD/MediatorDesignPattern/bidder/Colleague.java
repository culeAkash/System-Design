package LLD.MediatorDesignPattern.bidder;

public interface Colleague {
    public void placeBid(int amount);
    public void receiveNotification(int amount,String bidderName);
    public String getName();
}
