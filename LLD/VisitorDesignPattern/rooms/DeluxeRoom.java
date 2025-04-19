package LLD.VisitorDesignPattern.rooms;

import LLD.VisitorDesignPattern.visitor.Visitor;

public class DeluxeRoom implements Room {
    private int price;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
