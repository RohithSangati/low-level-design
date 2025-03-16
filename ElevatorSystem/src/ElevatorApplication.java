import elevator.Building;
import elevator.Direction;
import elevator.Floor;

public class ElevatorApplication {
	public static void main(String[] args) {

		Building building = new Building();
		Floor floor1 = new Floor(1);
		Floor floor2 = new Floor(2);
		Floor floor3 = new Floor(3);
		Floor floor4 = new Floor(4);
		Floor floor5 = new Floor(5);
		Floor floor6 = new Floor(6);
		Floor floor7 = new Floor(7);
		Floor floor8 = new Floor(8);
		building.addFloor(floor1);
		building.addFloor(floor2);
		building.addFloor(floor3);
		building.addFloor(floor4);
		building.addFloor(floor5);
		building.addFloor(floor6);
		building.addFloor(floor7);
		building.addFloor(floor8);

		floor1.pressButton(4, Direction.UP);

	}
}