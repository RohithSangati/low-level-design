package game;

public class Player {

	private String name;
	private PlayingPiece playingPiece;

	public Player(String name, PlayingPiece playingPiece) {
		super();
		this.name = name;
		this.playingPiece = playingPiece;
	}

	public String getName() {
		return name;
	}

	public PlayingPiece getPlayingPiece() {
		return playingPiece;
	}

}
