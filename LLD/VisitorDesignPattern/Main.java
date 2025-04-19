package LLD.VisitorDesignPattern;

import LLD.VisitorDesignPattern.rooms.DeluxeRoom;
import LLD.VisitorDesignPattern.visitor.RoomMaintenanceVisitor;
import LLD.VisitorDesignPattern.visitor.RoomPriceVisitor;

public class Main {
    public static void main(String[] args) {
        DeluxeRoom room = new DeluxeRoom();

        room.accept(new RoomPriceVisitor());
        room.accept(new RoomMaintenanceVisitor());

        System.out.println(room.getPrice());


    }
}
