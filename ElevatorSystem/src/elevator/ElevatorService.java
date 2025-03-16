package elevator;

import java.util.List;

public class ElevatorService {

	List<ElevatorCar> elevators;

	private static ElevatorService elevatorServiceInstance;

	private ElevatorService() {
	}

	public static ElevatorService getInstance() {
		if (elevatorServiceInstance == null) {
			synchronized (ElevatorService.class) {
				elevatorServiceInstance = new ElevatorService();
			}
		}
		return elevatorServiceInstance;
	}

	public void addElevator() {
		ElevatorCar elevatorCar = new ElevatorCar();
		this.elevators.add(elevatorCar);
		System.out.println("Successfully added elevator " + elevatorCar.getId());
	}

	public List<ElevatorCar> getElevators() {
		return elevators;
	}

}
