package model;

public class Road {

	public int id;
	public String name;
	public TrafficLight trafficLight;

	public Road(String name, TrafficLight trafficLight) {
		this.name = name;
		this.trafficLight = trafficLight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}

}
