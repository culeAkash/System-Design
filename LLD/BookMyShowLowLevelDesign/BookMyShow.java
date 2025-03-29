package LLD.BookMyShowLowLevelDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import LLD.BookMyShowLowLevelDesign.Seat.Seat;
import LLD.BookMyShowLowLevelDesign.Seat.SeatFactory;
import LLD.BookMyShowLowLevelDesign.Seat.SeatType;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;


    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }


    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();


        // create movies and theatres
        bookMyShow.initialize();


        // create booking
        bookMyShow.createBookings(City.KOLKATA,"Avengers");
        bookMyShow.createBookings(City.DELHI,"Andhaadhun");
        bookMyShow.createBookings(City.KOLKATA,"Avengers");
    }


    private void createBookings(City city, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(city);

        Movie interestedMovie = null;
        for(Movie movie : movies){
            if(movie.movieName.equals(movieName)){
                interestedMovie = movie;
                break;
            }
        }

        // get all show of movie in city
        Map<Theatre,List<Show>> shows = theatreController.getAllShows(interestedMovie,city);

        Map.Entry<Theatre,List<Show>> entry = shows.entrySet().iterator().next();
        List<Show> showList = entry.getValue();
        Show selectedShow = showList.get(0);

        // select seat number
        int seatNumber = 30;
        List<Integer> bookedSeats = selectedShow.bookedSeats;

        if(!bookedSeats.contains(seatNumber)){
            // start booking
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            booking.bookingId = 1;
            booking.status = BookingStatus.BOOKED;
            List<Seat> selectedSeats = new ArrayList<>();

            for(Seat seat : selectedShow.screen.seats){
                if(seat.position == seatNumber){
                    selectedSeats.add(seat);
                }
            }

            booking.selectedSeats = selectedSeats;
            booking.show = selectedShow;

            Payment payment = new Payment();
            payment.amountPaid = 100;
            payment.paymentId = 1;
            payment.paymentMode = PaymentMode.ONLINE;

            booking.payment = payment;
            System.out.println("seat successfully booked");
        }
        else{
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("seat successfully booked");

    }


    private void initialize() {
        createMovies();
        createTheatres();
    }


    private void createTheatres() {
        Theatre theatre1 = new Theatre(501, "PVR", City.KOLKATA);
        Theatre theatre2 = new Theatre(502, "INOX", City.DELHI);
        Theatre theatre3 = new Theatre(503, "INOX", City.MUMBAI);
        
        // create Screens
        theatre1.screens.add(createScreen());
        theatre2.screens.add(createScreen());
        theatre3.screens.add(createScreen());

        // create Shows
        Movie avengersMovie = movieController.getMovieByName("Avengers");
        Movie andhaadhunMovie = movieController.getMovieByName("Andhaadhun");

        Show show1 = createShows(1, avengersMovie, theatre1.screens.get(0), 8);
        Show show2 = createShows(2, andhaadhunMovie, theatre2.screens.get(0), 10);

        theatre1.shows.add(show1);
        theatre2.shows.add(show2);

        theatreController.addTheatre(theatre1, City.KOLKATA);
        theatreController.addTheatre(theatre2, City.DELHI);
    }


    private Show createShows(int id, Movie avengersMovie, Screen screen, int timing) {
        Show show = new Show(id, avengersMovie, screen, timing);
        return show;
    }


    private Screen createScreen() {
        Screen screen = new Screen(601);

        // create Seats
        screen.seats = createSeats(100);
        return screen;
    }


    private List<Seat> createSeats(int seatCount) {
        List<Seat> seats = new ArrayList<>();

        // MAKE SILVER SEATS FIRST
        for (int i = 1; i <= 50; i++) {
            Seat seat = SeatFactory.createSeat(SeatType.SILVER);
            seat.seatId = i;
            seat.position = i;
            seats.add(seat);
        }

        // MAKE GOLD SEATS
        for (int i = 51; i <= 80; i++) {
            Seat seat = SeatFactory.createSeat(SeatType.GOLD);
            seat.seatId = i;
            seat.position = i;
            seats.add(seat);
        }

        // MAKE PLATINUM SEATS
        for (int i = 81; i <= 100; i++) {
            Seat seat = SeatFactory.createSeat(SeatType.PLATINUM);
            seat.seatId = i;
            seat.position = i;
            seats.add(seat);
        }
        return seats;
    }


    private void createMovies() {
        // first movie
        Movie movie1 = new Movie(1, "Avengers", 180);

        // second movie
        Movie movie2 = new Movie(2, "Andhaadhun", 160);

        movieController.addMovie(movie1, City.KOLKATA);
        movieController.addMovie(movie2, City.KOLKATA);
        movieController.addMovie(movie2, City.DELHI);
        movieController.addMovie(movie2, City.MUMBAI);

    }
}
