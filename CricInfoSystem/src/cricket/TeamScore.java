package cricket;

public class TeamScore {

	private int score;
	private int wickets;

	public TeamScore(int score, int wickets) {
		this.score = score;
		this.wickets = wickets;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getScore() {
		return score;
	}

	public int getWickets() {
		return wickets;
	}

}
