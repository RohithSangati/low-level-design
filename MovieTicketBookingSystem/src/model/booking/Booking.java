package model.booking;

import java.util.ArrayList;
import java.util.UUID;

import model.Show;
import model.User;

public class Booking {

	private String bookingId;
	private Show show;
	private BookingStatus bookingStatus;
	private User bookedBy;
	private ArrayList<ArrayList<Integer>> seatNumbers;

	public Booking(Show show, BookingStatus bookingStatus, User bookedBy, ArrayList<ArrayList<Integer>> seatNumbers) {
		super();
		this.bookingId = UUID.randomUUID().toString();
		this.show = show;
		this.bookingStatus = bookingStatus;
		this.bookedBy = bookedBy;
		this.seatNumbers = seatNumbers;
	}

	public String getBookingId() {
		return bookingId;
	}

	public Show getShow() {
		return show;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public User getBookedBy() {
		return bookedBy;
	}

	public ArrayList<ArrayList<Integer>> getSeatNumbers() {
		return seatNumbers;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
