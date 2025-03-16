package elevator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {

	PriorityQueue<Integer> upQueue;
	PriorityQueue<Integer> downQueue;
	Queue<Integer> pendingQueue;

	public ElevatorController() {
		upQueue = new PriorityQueue<Integer>();
		downQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		pendingQueue = new LinkedList<Integer>();
	}

	public void acceptRequest(int floor, Direction direction, ElevatorCar elevator) {
		if (elevator.getState() == State.IDLE) {
			if (direction == Direction.UP) {
				elevator.setDirection(Direction.UP);
				upQueue.add(floor);
			} else {
				elevator.setDirection(Direction.DOWN);
				downQueue.add(floor);
			}
		} else if (elevator.getDirection() == Direction.UP) {
			if (direction == Direction.UP) {
				upQueue.add(floor);
			} else {
				pendingQueue.add(floor);
			}
		} else {
			if (direction == Direction.UP) {
				pendingQueue.add(floor);
			} else {
				downQueue.add(floor);
			}
		}
	}

	public void controlElevator(ElevatorCar elevatorCar) {
		while (true) {
			if (elevatorCar.getDirection() == Direction.UP) {

			}
		}
	}

}
