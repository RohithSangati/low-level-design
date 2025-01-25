package model;

public class TrafficLight {
	private int id;
	private int redSignalDuration;
	private int yelowSignalDuration;
	private int greenSignalDuration;
	private Signal currentSignal;

	public TrafficLight(int redSignalDuration, int yelowSignalDuration, int greenSignalDuration) {
		this.redSignalDuration = redSignalDuration;
		this.yelowSignalDuration = yelowSignalDuration;
		this.greenSignalDuration = greenSignalDuration;
		this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		this.currentSignal = Signal.RED;
	}

	public int getId() {
		return id;
	}

	public void setRedSignalDuration(int redSignalDuration) {
		this.redSignalDuration = redSignalDuration;
	}

	public void setYelowSignalDuration(int yelowSignalDuration) {
		this.yelowSignalDuration = yelowSignalDuration;
	}

	public void setGreenSignalDuration(int greenSignalDuration) {
		this.greenSignalDuration = greenSignalDuration;
	}

	public synchronized void changeCurrentSignal(Road road, Signal currentSignal) {
		this.currentSignal = currentSignal;
		System.out.println("Changed singal light of " + road.getName() + " to " + currentSignal.getValue());
	}

	public int getRedSignalDuration() {
		return redSignalDuration;
	}

	public int getYelowSignalDuration() {
		return yelowSignalDuration;
	}

	public int getGreenSignalDuration() {
		return greenSignalDuration;
	}

	public Signal getCurrentSignal() {
		return currentSignal;
	}

}
