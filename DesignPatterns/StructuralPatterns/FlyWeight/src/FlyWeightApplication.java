import factory.RobotFactory;
import model.Robot;

public class FlyWeightApplication {

	public static void main(String[] args) {

		Robot humanRobot1 = RobotFactory.createRobot("HUMANOID");
		humanRobot1.display(0, 0);
		humanRobot1.display(1, 2);
		humanRobot1.display(2, 4);

		Robot humanRobot2 = RobotFactory.createRobot("HUMANOID");
		humanRobot2.display(11, 12);
		humanRobot2.display(11, 23);
		humanRobot2.display(23, 43);

		Robot dobRobot1 = RobotFactory.createRobot("DOG");
		dobRobot1.display(10, 20);
		dobRobot1.display(31, 22);
		dobRobot1.display(27, 47);

		Robot dobRobot2 = RobotFactory.createRobot("DOG");
		dobRobot2.display(11, 1);
		dobRobot2.display(1, 23);
		dobRobot2.display(22, 49);
	}

}