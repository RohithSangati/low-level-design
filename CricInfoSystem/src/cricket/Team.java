package cricket;

import java.util.List;

public class Team {

	private String teamId;
	private String name;
	private List<Player> players;

	public Team(String name, List<Player> players) {
		this.players = players;
		this.name = name;
	}

	public String getTeamId() {
		return teamId;
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
