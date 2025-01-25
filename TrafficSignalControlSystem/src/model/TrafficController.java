package model;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {

	private Map<String, Road> roads;

	private static TrafficController trafficControllerInstance;

	private TrafficController() {
		this.roads = new HashMap<>();
	}

	public static TrafficController getTrafficControllerInstance() {
		if (trafficControllerInstance == null) {
			synchronized (TrafficController.class) {
				trafficControllerInstance = new TrafficController();
			}
		}
		return trafficControllerInstance;
	}

	public void addRoad(Road road) {
		roads.put(road.getName(), road);
	}

	public void removeRoad(Road road) {
		if (roads.containsKey(road.getName())) {
			roads.put(road.getName(), null);
		}
	}

	public void runTrafficSingal() {
		for (Road road : roads.values()) {
			TrafficLight trafficLight = road.getTrafficLight();
			new Thread(() -> {
				while (true) {
					try {
						Thread.sleep(trafficLight.getGreenSignalDuration());
						trafficLight.changeCurrentSignal(road, Signal.GREEN);
						Thread.sleep(trafficLight.getRedSignalDuration());
						trafficLight.changeCurrentSignal(road, Signal.RED);
						Thread.sleep(trafficLight.getYelowSignalDuration());
						trafficLight.changeCurrentSignal(road, Signal.YELLOW);
					} catch (Exception e) {
						System.out.println("Exception occured -" + e.toString());
					}
				}
			}).start();;
		}
	}

	public void emergencySignal(Road road) {
		TrafficLight trafficLight = road.getTrafficLight();
		trafficLight.changeCurrentSignal(road, Signal.GREEN);
		// And some more logic we want
	}

}
