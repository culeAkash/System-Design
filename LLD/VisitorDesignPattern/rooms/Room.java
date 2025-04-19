package LLD.VisitorDesignPattern.rooms;

import LLD.VisitorDesignPattern.visitor.Visitor;

public interface Room {
    public void accept(Visitor visitor);
}
