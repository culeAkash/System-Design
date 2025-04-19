package LLD.VisitorDesignPattern.visitor;

import LLD.VisitorDesignPattern.rooms.DeluxeRoom;
import LLD.VisitorDesignPattern.rooms.DoubleRoom;
import LLD.VisitorDesignPattern.rooms.SingleRoom;

public class RoomPriceVisitor implements Visitor {

    @Override
    public void visit(SingleRoom room) {
        room.setPrice(1000);
    }

    @Override
    public void visit(DoubleRoom room) {
        room.setPrice(2000);
    }

    @Override
    public void visit(DeluxeRoom room) {
        room.setPrice(3000);
    }

}
