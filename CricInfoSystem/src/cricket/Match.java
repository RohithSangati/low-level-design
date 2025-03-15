package cricket;

import java.time.LocalDateTime;
import java.util.List;

public class Match {

	private String matchId;
	private List<Team> teams;
	private ScoreCard scoreCard;
	private LocalDateTime startTime;
	private MatchStatus matchStatus;
	private String venue;
	private String title;

	public Match(String matchId, List<Team> teams, ScoreCard scoreCard, String venue, String title) {
		super();
		this.matchId = matchId;
		this.teams = teams;
		this.scoreCard = scoreCard;
		this.startTime = LocalDateTime.now();
		this.matchStatus = MatchStatus.SCHEDULED;
		this.venue = venue;
		this.title = title;
	}

	public String getMatchId() {
		return matchId;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public ScoreCard getScoreCard() {
		return scoreCard;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public MatchStatus getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}

	public String getVenue() {
		return venue;
	}

	public String getTitle() {
		return title;
	}

}
