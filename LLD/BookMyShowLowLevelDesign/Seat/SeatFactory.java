package LLD.BookMyShowLowLevelDesign.Seat;

public class SeatFactory {
    public static Seat createSeat(SeatType seatType) {
        switch (seatType) {
            case GOLD:
                return new GoldSeat();
            case SILVER:
                return new SilverSeat();
            case PLATINUM:
                return new PlatinumSeat();
            default:
                return null;
        }
    }
}


