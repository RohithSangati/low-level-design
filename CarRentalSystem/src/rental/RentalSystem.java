package rental;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import payment.PaymentFactory;
import payment.PaymentProcessor;

public class RentalSystem {

	private Map<String, Car> carMap;
	private Map<Integer, Customer> customerMap;
	private Map<Integer, Reservation> reservationMap;
	private static RentalSystem rentalSystem;
	Scanner sc = new Scanner(System.in);

	private RentalSystem() {
		this.carMap = new HashMap<>();
		this.customerMap = new HashMap<>();
		this.reservationMap = new HashMap<>();
	}

	public static RentalSystem getRentalSystem() {
		if (rentalSystem == null) {
			synchronized (RentalSystem.class) {
				rentalSystem = new RentalSystem();
			}
		}
		return rentalSystem;
	}

	public void addCar(Car car) {
		this.carMap.put(car.getLicensePlateNumber(), car);
	}

	public void addCustomer(Customer customer) {
		this.customerMap.put(customer.getId(), customer);
	}

	public List<Car> findCar(String make, CarType model, int minPrice, int maxPrice, Date fromDate, Date toDate) {
		List<Car> availableCars = new ArrayList<>();
		if (fromDate.after(toDate) || fromDate.before(new Date())) {
			System.out.println("Invalid from Date and to Date");
			return availableCars;
		}
		for (Car car : carMap.values()) {
			if (car.getMake().equalsIgnoreCase(make) && car.getModel().equals(model) && car.getPricePerDay() >= minPrice
					&& car.getPricePerDay() <= maxPrice) {
				if (isCarAvailable(car, fromDate, toDate)) {
					availableCars.add(car);
				}
			}
		}
		return availableCars;
	}

	public boolean isCarAvailable(Car car, Date fromDate, Date toDate) {
		for (Reservation reservation : this.reservationMap.values()) {
			if (reservation.getCar().equals(car)
					&& ((!fromDate.before(reservation.getFromDate()) && !fromDate.after(reservation.getToDate()))
							|| (!toDate.before(reservation.getFromDate()) && !toDate.after(reservation.getToDate())))
					&& reservation.getBookingStatus().equals(BookingStatus.BOOKED)) {
				return false;
			}
		}
		return true;
	}

	public synchronized int bookCar(Car car, Date fromDate, Date toDate, Customer customer) {
		if (isCarAvailable(car, fromDate, toDate)) {
			Reservation reservation = Reservation.createReservation(fromDate, toDate, car, customer);
			double price = reservation.getPrice();
			boolean paymentSuccessfull = initiatePayment(price);
			if (paymentSuccessfull) {
				reservation.setBookingStatus(BookingStatus.BOOKED);
				System.out.println("Car - " + car.getLicensePlateNumber() + " Successfully booked!!!!"
						+ " Reservation ID - " + reservation.getReservationId());
			} else {
				reservation.setBookingStatus(BookingStatus.PAYMENT_FAILED);
				System.out.println("Car - " + car.getLicensePlateNumber() + "not booked as payment process failed");
			}
			this.reservationMap.put(reservation.getReservationId(), reservation);
			return reservation.getReservationId();
		} else {
			System.out.println("Selected car is not available to book at this moment");
		}
		return -1;
	}

	public void cancelReservation(Reservation reservation) {
		if (!reservation.getBookingStatus().equals(BookingStatus.BOOKED)) {
			System.out.println("Reservation is not booked to cancel");
		} else {
			reservation.setBookingStatus(BookingStatus.CANCELLED);
			System.out.println("Reservation with id - " + reservation.getReservationId() + " is successfully cancelled");
		}
	}

	public boolean initiatePayment(double price) {
		System.out.println("Enter the prefered payment from payment methods shown to proceed payment - UPI/CREDITCARD");
		String method = sc.next();
		PaymentProcessor paymentProcessor = PaymentFactory.getPaymentProcessor(method);
		if (paymentProcessor != null) {
			return paymentProcessor.pay(price);
		}
		System.out.println("Selected payment method is invalid!!!");
		return false;
	}

	public Reservation getReservationById(int id) {
		return this.reservationMap.get(id);
	}

}
