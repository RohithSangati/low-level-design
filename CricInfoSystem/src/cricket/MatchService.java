package cricket;

import java.util.HashMap;

public class MatchService {

	private static MatchService matchService;
	HashMap<String, Match> matches;

	private MatchService() {
		matches = new HashMap<>();
	}

	public static MatchService getInstance() {
		if (matchService == null) {
			synchronized (MatchService.class) {
				matchService = new MatchService();
			}
		}
		return matchService;
	}

	public void addMatch(Match match) {
		matches.put(match.getMatchId(), match);
	}
	
	public Match getMatch(String id) {
		return matches.get(id);
	}

	public void updateMatchStatus(Match match, MatchStatus status) {
		match.setMatchStatus(status);
	}

}
