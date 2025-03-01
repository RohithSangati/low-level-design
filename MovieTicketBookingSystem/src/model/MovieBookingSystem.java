package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import model.booking.Booking;
import model.booking.BookingStatus;
import model.seat.SeatStatus;
import model.seat.SeatType;

public class MovieBookingSystem {

	private static MovieBookingSystem movieBookingSystem;
	private HashMap<String, User> usersList;
	private HashMap<String, Theatre> theatreList;
	private HashMap<String, Show> showsList;
	private HashMap<String, Movie> movieList;
	private HashMap<String, Booking> bookingList;
	private Scanner sc;

	private MovieBookingSystem() {
		usersList = new HashMap<>();
		theatreList = new HashMap<>();
		movieList = new HashMap<>();
		showsList = new HashMap<>();
		bookingList = new HashMap<>();
		sc = new Scanner(System.in);
	}

	public static MovieBookingSystem getInstance() {
		if (movieBookingSystem == null) {
			synchronized (MovieBookingSystem.class) {
				movieBookingSystem = new MovieBookingSystem();
			}
		}
		return movieBookingSystem;
	}

	private boolean isUserExisits(String email) {
		for (User user : this.usersList.values()) {
			if (user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public User addUser(String name, String email) {
		if (isUserExisits(email)) {
			System.out.println("User with same email already exists");
			return null;
		}
		User user = new User(name, email);
		this.usersList.put(user.getUserId(), user);
		System.out.println("User - " + user.getName() + " successfully added to the system");
		return user;
	}

	private boolean isTheatreExists(String name, String location) {
		for (Theatre theatre : this.theatreList.values()) {
			if (theatre.getLocation().equals(location) && theatre.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public Theatre addTheatre(String name, String location) {
		if (this.isTheatreExists(name, location)) {
			System.out.println("Theatre already exisits with same name and location");
			return null;
		}
		Theatre theatre = new Theatre(name, location);
		this.theatreList.put(theatre.getTheatreId(), theatre);
		System.out.println("Successfully added theatre to the system");
		return theatre;
	}

	public void makeTheatreAdminstrator(User user, Theatre theatre) {
		theatre.addAdministrator(user);
	}

	public Movie addMovie(String name, String description, int duration) {
		Movie movie = new Movie(name, description, duration);
		this.movieList.put(movie.getMovieId(), movie);
		System.out.println("Successfully added Movie -"+name);
		return movie;
	}

	private boolean isAllowedToAddShow(LocalDateTime startTime, LocalDateTime endTime, Movie movie, Theatre theatre,
			User user) {
		if (theatre.getAdministrator(user.getEmail()) == null) {
			System.out.println("Given user is not theatre administrator to add the show");
			return false;
		}
		if (!startTime.isBefore(endTime)) {
			System.out.println("Start time must be grater than end time");
			return false;
		}
		long minutesDifference = ChronoUnit.MINUTES.between(startTime, endTime);
		if (minutesDifference < movie.getDurationInMinutes()) {
			System.out.println("Insufficient duration for show for given movie");
			return false;
		}
		for (Show show : this.showsList.values()) {
			if (show.getMovie().equals(movie) && show.getTheatre().equals(theatre)
					&& startTime.isAfter(show.getStartTime()) && startTime.isBefore(endTime)) {
				System.out.println("There is already conflict with the show and movie with the same theatre..");
				return false;
			}
		}
		return true;
	}

	public Show addShow(Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, int n, int price,
			User user) {
		if (isAllowedToAddShow(startTime, endTime, movie, theatre, user)) {
			Show show = new Show(movie, theatre, startTime, endTime, n, price);
			this.showsList.put(show.getShowId(), show);
			System.out.println("Successfully added show for the movie - " + movie.getName() + " and theatre - "
					+ theatre.getName());
			return show;
		}
		return null;
	}

	private boolean isAllowedToModifyShowSeatType(User user, Show show) {
		if (show.getTheatre().getAdministrator(user.getEmail()) == null) {
			System.out.println("Given user is not a theatre administrator!!");
			return false;
		}
		return true;
	}

	public void changeSeat(int row, int col, int price, SeatType seatType, User user, Show show) {
		if (isAllowedToModifyShowSeatType(user, show)) {
			show.setSeatType(row, col, price, seatType);
		}
	}

	public void displaySeats(Show show) {
		show.display();
	}

	public void displayAllShows() {
		for (Show show : this.showsList.values()) {
			System.out.println(show);
		}
	}

	public void showTheatresByMovie(Movie movie, LocalDateTime startTime, LocalDateTime endTime) {
		HashSet<Show> track = new HashSet<>();
		for (Show show : this.showsList.values()) {
			if (show.getMovie().equals(movie) && show.getStartTime().isAfter(startTime)
					&& show.getStartTime().isBefore(endTime) && !track.contains(show)) {
				System.out.println(show.getTheatre());
				track.add(show);
			}
		}
	}

	private synchronized boolean isSeatsAvailable(ArrayList<ArrayList<Integer>> seats, Show show) {
		for (ArrayList<Integer> seatNumbers : seats) {
			if (!show.isSeatAvailable(seatNumbers.getFirst(), seatNumbers.getLast())) {
				System.out.println(seatNumbers.getFirst() + ":" + seatNumbers.getLast() + " is already occupied!!!");
				return false;
			}
		}
		return true;
	}

	private void changeSeatStatus(ArrayList<ArrayList<Integer>> seats, Show show, SeatStatus seatStatus) {
		for (ArrayList<Integer> seatNumbers : seats) {
			show.setSeatStatus(seatNumbers.getFirst(), seatNumbers.getLast(), seatStatus);
		}
	}

	private void confirmBooking(Show show, Booking booking, ArrayList<ArrayList<Integer>> seats) {
		System.out.println("Please press 1 to confirm booking!!");
		int confirmationNumber = sc.nextInt();
		if (confirmationNumber != 1) {
			booking.setBookingStatus(BookingStatus.CANCELLED);
			changeSeatStatus(seats, show, SeatStatus.AVAILABLE);
		} else {
			System.out.println("Please enter 1 for UPI payment and 2 for Credit Card Payment");
			int confirmationPayment = sc.nextInt();
			while (confirmationPayment != 1 && confirmationPayment != 2) {
				System.out.println("Invalid payment method selected,please enter again!!!!");
				confirmationPayment = sc.nextInt();
			}
			switch (confirmationPayment) {
			case 1:
				System.out.println("payment method implementation for UPI");
				break;
			case 2:
				System.out.println("Payment method implementation for credit card");
				break;
			default:
				break;
			}
			booking.setBookingStatus(BookingStatus.CONFIRMED);
		}
	}

	public synchronized Booking bookTicket(User user, ArrayList<ArrayList<Integer>> seats, Show show) {
		if (isSeatsAvailable(seats, show)) {
			Booking booking = new Booking(show, BookingStatus.PENDING, user, seats);
			this.bookingList.put(booking.getBookingId(), booking);
			changeSeatStatus(seats, show, SeatStatus.FILLED);
			confirmBooking(show, booking, seats);
			return booking;
		}
		return null;
	}

	public void cancelBooking(Booking booking) {
		if (booking.getShow().getStartTime().isBefore(LocalDateTime.now())) {
			System.out.println("You are not allowed to cancel ticket now as show is already started!!!");
			return;
		}
		booking.setBookingStatus(BookingStatus.CANCELLED);
		changeSeatStatus(booking.getSeatNumbers(), booking.getShow(), SeatStatus.AVAILABLE);
	}

}
