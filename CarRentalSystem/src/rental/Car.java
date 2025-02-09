package rental;

public class Car {

	private String make;
	private CarType model;
	private int year;
	private String licensePlateNumber;
	private int pricePerDay;

	public Car(String make, CarType model, int year, String licensePlateNumber, int pricePerDay) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlateNumber = licensePlateNumber;
		this.pricePerDay = pricePerDay;
	}

	public String getMake() {
		return make;
	}

	public CarType getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", licensePlateNumber="
				+ licensePlateNumber + ", pricePerDay=" + pricePerDay + "]";
	}

}
