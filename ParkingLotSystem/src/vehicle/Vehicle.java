package vehicle;

public abstract class Vehicle {

	protected VehicleType type;
	protected String vehicleNumber;

	Vehicle(VehicleType type, String vehicleNumber) {
		this.type = type;
		this.vehicleNumber = vehicleNumber;
	}

	public VehicleType getType() {
		return this.type;
	}
	
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}

}
