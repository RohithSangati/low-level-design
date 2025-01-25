import model.Road;
import model.TrafficController;
import model.TrafficLight;

class TrafficControlApplication {

	public static void main(String[] args) {

		TrafficController trafficController = TrafficController.getTrafficControllerInstance();

		TrafficLight light1 = new TrafficLight(1000, 2000, 3000);
		TrafficLight light2 = new TrafficLight(2000, 1000, 4000);

		Road road1 = new Road("Road1", light1);
		Road road2 = new Road("Road2", light2);
		
		trafficController.addRoad(road1);
		trafficController.addRoad(road2);
		
		trafficController.runTrafficSingal();

	}

}