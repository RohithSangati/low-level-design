package elevator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {

	PriorityQueue<Integer> upQueue;
	PriorityQueue<Integer> downQueue;
	Queue<Request> pendingQueue;

	public ElevatorController() {
		upQueue = new PriorityQueue<Integer>();
		downQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		pendingQueue = new LinkedList<Request>();
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
			if (direction == Direction.UP && floor > elevator.getCurrentFloor()) {
				upQueue.add(floor);
			} else {
				if (direction == Direction.UP) {
					pendingQueue.add(new Request(floor, direction));
				} else {
					downQueue.add(floor);
				}
			}
		} else {
			if (direction == Direction.DOWN && floor < elevator.getCurrentFloor()) {
				downQueue.add(floor);
			} else {
				if (direction == Direction.DOWN) {
					pendingQueue.add(new Request(floor, direction));
				} else {
					upQueue.add(floor);
				}
			}
		}
	}

	public void controlElevator(ElevatorCar elevatorCar) {
		while (true) {
			int currFloor = 0;
			if (elevatorCar.getDirection() == Direction.UP) {
				while (upQueue.size() != 0) {
					currFloor = upQueue.poll();
					System.out.println("Covered " + currFloor + " up");
				}
				elevatorCar.setDirection(Direction.DOWN);
				if (downQueue.size() != 0)
					continue;
			} else {
				while (downQueue.size() != 0) {
					currFloor = downQueue.poll();
					System.out.println("Covered " + currFloor + " down");
				}
				elevatorCar.setDirection(Direction.UP);
				if (upQueue.size() != 0)
					continue;
			}
			if (pendingQueue.size() != 0) {
				Direction nextDirection = elevatorCar.getDirection();
				int size = pendingQueue.size();
				for (int i = 0; i < size; i++) {
					Request requestedFloor = pendingQueue.poll();
					if (nextDirection == requestedFloor.getDirection()) {
						if (nextDirection == Direction.UP) {
							upQueue.add(requestedFloor.getFloor());
						} else {
							downQueue.add(requestedFloor.getFloor());
						}
					} else {
						pendingQueue.add(requestedFloor);
					}
				}
			} else {
				elevatorCar.setCurrentFloor(currFloor);
				elevatorCar.setState(State.IDLE);
				break;
			}
		}
	}

}
