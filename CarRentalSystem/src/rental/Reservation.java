package rental;

import java.util.Date;

public class Reservation {

	private Date fromDate;
	private Date toDate;
	private Car car;
	private Customer customer;
	private int reservationId;
	private double price;
	private BookingStatus bookingStatus;

	Reservation(Date fromDate, Date toDate, Car car, Customer customer, double price) {
		this.reservationId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.car = car;
		this.customer = customer;
		this.price = price;
		this.bookingStatus = BookingStatus.PENDING;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getReservationId() {
		return reservationId;
	}

	public double getPrice() {
		return price;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public static double calculatePrice(int price, Date fromDate, Date toDate) {
		long numberOfDays = (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24);
		return (numberOfDays + 1) * price;
	}

	public static Reservation createReservation(Date fromDate, Date toDate, Car car, Customer customer) {
		double price = calculatePrice(car.getPricePerDay(), fromDate, toDate);
		Reservation reservation = new Reservation(fromDate, toDate, car, customer, price);
		return reservation;
	}

}
