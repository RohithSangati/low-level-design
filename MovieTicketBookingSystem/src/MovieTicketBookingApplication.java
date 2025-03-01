import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import model.Movie;
import model.MovieBookingSystem;
import model.Show;
import model.Theatre;
import model.User;
import model.booking.Booking;
import model.seat.SeatType;

public class MovieTicketBookingApplication {
	public static void main(String[] args) {
		MovieBookingSystem movieBookingSystem = MovieBookingSystem.getInstance();

		User rohith = movieBookingSystem.addUser("Rohith", "rohit.s@gmail.com");
		User moulika = movieBookingSystem.addUser("Moulika", "moulika.s@gmail.com");
		User dorababu = movieBookingSystem.addUser("Dora Babu", "dorababu.k@gmail.com");

		Theatre miraz = movieBookingSystem.addTheatre("Miraz", "Hyderabad");
		Theatre pvr = movieBookingSystem.addTheatre("PVR", "Tirupati");
		Theatre sandhya = movieBookingSystem.addTheatre("Sandhya", "Hyderabad");

		movieBookingSystem.makeTheatreAdminstrator(rohith, pvr);

		Movie devara = movieBookingSystem.addMovie("Devara", "Fear of fear", 180);
		Movie pushpa = movieBookingSystem.addMovie("Pushpa", "A story of sandalwood smuggling!", 240);

		Show show1 = movieBookingSystem.addShow(devara, pvr, LocalDateTime.of(2025, Month.DECEMBER, 24, 14, 0),
				LocalDateTime.of(2025, Month.DECEMBER, 25, 17, 0), 10, 300, rohith);
		Show show2 = movieBookingSystem.addShow(pushpa, pvr, LocalDateTime.of(2025, Month.DECEMBER, 24, 18, 0),
				LocalDateTime.of(2025, Month.DECEMBER, 25, 22, 0), 10, 800, rohith);

		movieBookingSystem.displayAllShows();

		movieBookingSystem.showTheatresByMovie(pushpa, LocalDateTime.of(2025, Month.DECEMBER, 25, 14, 0),
				LocalDateTime.of(2025, Month.DECEMBER, 25, 19, 0));

		movieBookingSystem.displaySeats(show2);

		for (int i = 8; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				movieBookingSystem.changeSeat(i, j, 1000, SeatType.PREMIUM, rohith, show2);
			}
		}

		movieBookingSystem.displaySeats(show2);

		ArrayList<ArrayList<Integer>> seats = new ArrayList<>();

		ArrayList<Integer> seat1 = new ArrayList<>();
		seat1.add(0);
		seat1.add(1);
		ArrayList<Integer> seat2 = new ArrayList<>();
		seat2.add(9);
		seat2.add(2);

		seats.add(seat1);
		seats.add(seat2);
		Booking booking = movieBookingSystem.bookTicket(dorababu, seats, show2);

		movieBookingSystem.displaySeats(show2);
		
		movieBookingSystem.cancelBooking(booking);

		movieBookingSystem.displaySeats(show2);
		
	}
}