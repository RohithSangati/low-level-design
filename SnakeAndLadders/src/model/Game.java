package model;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

	Queue<Player> players;
	Board board;
	private int currentWinnerPosition;
	private int numberOfDice;

	public Game(int numberOfDice) {
		players = new LinkedList<>();
		board = new Board();
		currentWinnerPosition = 1;
		this.numberOfDice = numberOfDice;
	}

	public boolean addPlayer(String name) {
		Player player = this.board.addPlayer(name);
		if (player != null) {
			players.add(player);
		}
		return player != null;
	}

	public boolean addSnake(int head, int tail) {
		return this.board.addSnake(head, tail) != null;
	}

	public boolean addLadder(int start, int end) {
		return this.board.addLadder(start, end) != null;
	}

	public void startGame() {
		Dice dice = new Dice(this.numberOfDice);
		while (players.size() != 0) {
			Player currPlayer = players.poll();
			int diceResult = dice.rollDice();
			int nextPosition = currPlayer.getCurrPos() + diceResult;
			System.out.println(currPlayer.getName() + " ::::: " + diceResult + " ::::: " + nextPosition);
			if (nextPosition > 100) {
				System.out.println("Position limit exceeded..");
				players.add(currPlayer);
			} else {
				int nextPosForPlayer = this.board.getNextPosition(nextPosition);
				if (nextPosForPlayer == 100) {
					System.out.println(
							currPlayer.getName() + " won the match with position - " + currentWinnerPosition++);
				} else {
					currPlayer.setCurrPos(nextPosForPlayer);
					players.add(currPlayer);
				}
			}
		}
	}

}
