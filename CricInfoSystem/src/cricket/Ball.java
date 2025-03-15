package cricket;

public class Ball {

	private String bowler;
	private String batsman;
	private Integer result;
	private int ballNumber;
	private String comment;

	public Ball(String bowler, String batsman, Integer result, int ballNumber, String comment) {
		super();
		this.bowler = bowler;
		this.batsman = batsman;
		this.result = result;
		this.ballNumber = ballNumber;
		this.comment = comment;
	}

	public String getBowler() {
		return bowler;
	}

	public String getBatsman() {
		return batsman;
	}

	public Integer getResult() {
		return result;
	}

	public int getBallNumber() {
		return ballNumber;
	}

	public String getComment() {
		return comment;
	}

}
