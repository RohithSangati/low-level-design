import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Game;

public class SnakeAndLadderApplication {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		List<Game> games = new ArrayList<>();

		System.out.println("Enter Number of games");
		int numberOfGames = s.nextInt();
		int gameNumber = 1;

		while (gameNumber <= numberOfGames) {
			System.out.println("Enter Number of dice for Game -" + gameNumber);
			int numberOfDice = s.nextInt();
			Game game = new Game(numberOfDice);
			System.out.println("Enter Number of players for Game -" + gameNumber);
			int numberOfPlayers = s.nextInt();
			System.out.println("Enter Number of snakes for Game -" + gameNumber);
			int numberOfSnakes = s.nextInt();
			System.out.println("Enter Number of ladders for Game -" + gameNumber);
			int numberOfLadders = s.nextInt();
			while (numberOfSnakes > 0) {
				System.out.println("Enter head position for snake");
				int head = s.nextInt();
				System.out.println("Enter tail position for snake");
				int tail = s.nextInt();
				if (game.addSnake(head, tail)) {
					numberOfSnakes--;
				}
			}
			while (numberOfLadders > 0) {
				System.out.println("Enter start position for ladder");
				int start = s.nextInt();
				System.out.println("Enter end position for ladder");
				int end = s.nextInt();
				if (game.addLadder(start, end)) {
					numberOfLadders--;
				}
			}
			while (numberOfPlayers > 0) {
				System.out.println("Enter the name of the player");
				String name = s.next();
				if (game.addPlayer(name)) {
					numberOfPlayers--;
				}
			}
			games.add(game);
			gameNumber++;
		}

		for (Game game : games) {
			System.out.println("Thread started !!!");
			new Thread(() -> game.startGame()).start();
		}

	}
}