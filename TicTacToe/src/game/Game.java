package game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

	Queue<Player> playersQueue;
	Board board;
	Scanner s = new Scanner(System.in);

	public Game(int n) {
		this.board = new Board(n);
		this.playersQueue = new LinkedList<>();
	}

	public void addPlayer(Player player) {
		this.playersQueue.add(player);
		System.out.println("Successfully added Player " + player.getName());
	}

	public void startGame() {
		board.displayBoard();
		while (true) {
			Player currentPlayer = playersQueue.peek();
			System.out.println("Current Turn - " + currentPlayer.getName());
			System.out.println("Enter Values of x and y");
			int x = s.nextInt();
			int y = s.nextInt();
			if (!board.isAllowedToInsert(x, y)) {
				System.out.println("Not Allowed to insert at given position");
				continue;
			}
			board.insertPiece(x, y, currentPlayer.getPlayingPiece());
			String status = board.getStatus(x, y, currentPlayer.getPlayingPiece());
			if (status == "WON") {
				System.out.println("Player - " + currentPlayer.getName() + " won the game!!!!!!");
				break;
			} else if (status == "DRAW") {
				System.out.println("Match Drawn!!!!!");
				break;
			}
			playersQueue.add(playersQueue.poll());
		}
		System.out.println("Game completed!!!");
	}

	public void initializeGame(int n) {
		System.out.println("Intializing the game");
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Playing Piece name");
			String pieceName = s.next();
			System.out.println("Enter Playing Player name");
			String playerName = s.next();
			PlayingPiece playingPiece = new PlayingPiece(pieceName);
			Player player = new Player(playerName, playingPiece);
			this.addPlayer(player);
		}
	}

}
