package LLD.VisitorDesignPattern.visitor;

import LLD.VisitorDesignPattern.rooms.DeluxeRoom;
import LLD.VisitorDesignPattern.rooms.DoubleRoom;
import LLD.VisitorDesignPattern.rooms.SingleRoom;

public interface Visitor {
    
    void visit(SingleRoom room);
    void visit(DoubleRoom room);
    void visit(DeluxeRoom room);
}
