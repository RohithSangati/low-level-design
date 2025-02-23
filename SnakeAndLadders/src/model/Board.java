package model;

import java.util.HashMap;

public class Board {

	HashMap<String, Player> players;
	HashMap<Integer, Snake> snakes;
	HashMap<Integer, Ladder> ladders;

	public Board() {
		this.players = new HashMap<String, Player>();
		this.snakes = new HashMap<Integer, Snake>();
		this.ladders = new HashMap<Integer, Ladder>();
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public HashMap<Integer, Snake> getSnakes() {
		return snakes;
	}

	public HashMap<Integer, Ladder> getLadders() {
		return ladders;
	}

	public Player addPlayer(String name) {
		if (this.players.containsKey(name)) {
			System.out.println("Player with same name already exisits");
			return null;
		}
		Player player = new Player(name, 0, 0);
		this.players.put(name, player);
		System.out.println("Successfully added player " + player.getName());
		return player;
	}

	public Snake addSnake(int head, int tail) {
		if (head <= tail) {
			System.out.println("Head must be greated than tail");
			return null;
		}
		if (this.snakes.containsKey(head)) {
			System.out.println("There is already a snake at given head position");
			return null;
		}
		Snake snake = new Snake(head, tail);
		this.snakes.put(head, snake);
		System.out.println("Successfully added snake with head postion - " + head + " : tail - " + tail);
		return snake;
	}

	public Ladder addLadder(int start, int end) {
		if (start >= end) {
			System.out.println("Start must be lesser than end");
			return null;
		}
		if (this.ladders.containsKey(start)) {
			System.out.println("There is already a ladder at given position");
			return null;
		}
		Ladder ladder = new Ladder(start, end);
		this.ladders.put(start, ladder);
		System.out.println("Successfully added ladder with start position - " + start + " : end - " + end);
		return ladder;
	}

	public int getNextPosition(int position) {
		if (this.snakes.containsKey(position)) {
			System.out.println("Snake bitten");
			return this.snakes.get(position).getTail();
		} else if (this.ladders.containsKey(position)) {
			System.out.println("Climbed ladder");
			return this.ladders.get(position).getEnd();
		} else {
			System.out.println("Position changed");
			return position;
		}
	}

}