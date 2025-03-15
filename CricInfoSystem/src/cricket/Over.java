package cricket;

import java.util.List;

public class Over {

	private Integer overNumber;
	private List<Ball> balls;

	public Over(Integer overNumber, List<Ball> balls) {
		super();
		this.overNumber = overNumber;
		this.balls = balls;
	}

	public Integer getOverNumber() {
		return overNumber;
	}

	public List<Ball> getBalls() {
		return balls;
	}
}
