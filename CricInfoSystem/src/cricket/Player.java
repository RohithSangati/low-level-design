package cricket;

import java.util.UUID;

public class Player {

	private String playerId;
	private String name;
	private String role;

	public Player(String name, String role) {
		this.playerId = UUID.randomUUID().toString();
		this.name = name;
		this.role = role;
	}

	public String getPlayerId() {
		return playerId;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

}
