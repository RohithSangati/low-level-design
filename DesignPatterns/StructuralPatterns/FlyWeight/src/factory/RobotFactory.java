package factory;

import java.util.HashMap;

import model.DogRobot;
import model.HumanoidRobot;
import model.Robot;
import model.Sprites;

public class RobotFactory {

	public static HashMap<String, Robot> cache = new HashMap<>();
	

	public static Robot createRobot(String type) {
		if (cache.containsKey(type)) {
			System.out.println(type);
			return cache.get(type);
		} else {
			switch (type) {
			case "HUMANOID":
				Robot humonoidRobot = new HumanoidRobot(type, new Sprites());
				System.out.println(type + " 1st time");
				cache.put(type, humonoidRobot);
				return humonoidRobot;
			case "DOG":
				Robot dogRobot = new DogRobot(type, new Sprites());
				cache.put(type, dogRobot);
				System.out.println(type + " 1st time");
				return dogRobot;
			default:
				return null;
			}
		}
	}

}
