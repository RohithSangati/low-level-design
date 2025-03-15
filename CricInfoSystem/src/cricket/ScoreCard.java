package cricket;

import java.util.HashMap;
import java.util.List;

public class ScoreCard {

	private String scoreCardId;
	private HashMap<String, TeamScore> teamScores;
	private List<Innings> innings;

	public ScoreCard(String scoreCardId, HashMap<String, TeamScore> teamScores, List<Innings> innings) {
		super();
		this.scoreCardId = scoreCardId;
		this.teamScores = teamScores;
		this.innings = innings;
	}

	public String getScoreCardId() {
		return scoreCardId;
	}

	public HashMap<String, TeamScore> getTeamScores() {
		return teamScores;
	}

	public List<Innings> getInnings() {
		return innings;
	}

	public void updateScore(String teamId, int runsAdded) {
		TeamScore score = teamScores.get(teamId);
		score.setScore(score.getScore() + runsAdded);
		System.out.println("Successfully updated score!!");
	}

	public void addWicket(String teamId) {
		TeamScore score = teamScores.get(teamId);
		score.setWickets(score.getWickets() + 1);
		System.out.println("Successfully updated wickets!!");
	}

}
