package cricket;

import java.util.List;

public class Innings {

	private String inningsId;
	private List<Over> overs;
	private String battingTeam;
	private String bowlingTeam;

	public Innings(String inningsId, List<Over> overs, String battingTeam, String bowlingTeam) {
		super();
		this.inningsId = inningsId;
		this.overs = overs;
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
	}

	public String getInningsId() {
		return inningsId;
	}

	public List<Over> getOvers() {
		return overs;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public String getBowlingTeam() {
		return bowlingTeam;
	}

}
