import model.Vehicle;
import model.VehicleFactory;

public class NullObjectApplication {

	public static void main(String[] args) {
		
		Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
		System.out.println(vehicle1.getFuelCapacity() + ":" + vehicle1.getSeatCapacity());
		

		Vehicle vehicle2 = VehicleFactory.getVehicle("Bike");
		System.out.println(vehicle2.getFuelCapacity() + ":" + vehicle2.getSeatCapacity());
		
	}

}