package LLD.VisitorDesignPattern.visitor;

import LLD.VisitorDesignPattern.rooms.DeluxeRoom;
import LLD.VisitorDesignPattern.rooms.DoubleRoom;
import LLD.VisitorDesignPattern.rooms.SingleRoom;

public class RoomMaintenanceVisitor implements Visitor {

    @Override
    public void visit(SingleRoom room) {
       System.out.println("Cleaning the single room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Cleaning the double room");
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Cleaning the deluxe room");
    }

}
