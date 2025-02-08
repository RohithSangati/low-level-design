import java.util.Scanner;

import game.Game;

class TicTacToeApplication {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter Board Size");
		int boardSize = s.nextInt();

		System.out.println("Enter Number of Players");
		int noOfPlayers = s.nextInt();

		Game game = new Game(boardSize);

		game.initializeGame(noOfPlayers);

		game.startGame();
	}
}