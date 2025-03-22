package elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorService {

	List<ElevatorCar> elevators;

	private static ElevatorService elevatorServiceInstance;

	private ElevatorService() {
		elevators = new ArrayList<ElevatorCar>();
	}	

	public static ElevatorService getInstance() {
		if (elevatorServiceInstance == null) {
			synchronized (ElevatorService.class) {
				elevatorServiceInstance = new ElevatorService();
			}
		}
		return elevatorServiceInstance;
	}

	public ElevatorCar addElevator() {
		ElevatorCar elevatorCar = new ElevatorCar();
		this.elevators.add(elevatorCar);
		System.out.println("Successfully added elevator " + elevatorCar.getId());
		return elevatorCar;
	}

	public List<ElevatorCar> getElevators() {
		return elevators;
	}

}
