package game;

public class Board {

	PlayingPiece[][] board;
	private int remainingPositions;

	public Board(int n) {
		this.remainingPositions = n * n;
		board = new PlayingPiece[n][n];
	}

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				String cell = (j == 0 ? "|" : "") + (board[i][j] == null ? "-" : board[i][j].getName()) + "|";
				System.out.print(cell);
			}
			System.out.println();
		}
	}

	public boolean isAllowedToInsert(int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board.length && board[i][j] == null;
	}

	public void insertPiece(int x, int y, PlayingPiece piece) {
		board[x][y] = piece;
		System.out.println("Success fully Inserted Playin Piece " + piece.getName() + " at " + x + " and " + y);
		this.displayBoard();
	}

	public String getStatus(int x, int y, PlayingPiece piece) {
		int n = board.length;

		// Checking horizontally
		for (int j = 0; j < n; j++) {
			if (board[x][j] != piece) {
				break;
			}
			if (j == n - 1) {
				return "WON";
			}
		}

		// Checking vertically
		for (int i = 0; i < n; i++) {
			if (board[i][y] != piece) {
				break;
			}
			if (i == n - 1) {
				return "WON";
			}
		}

		// Checking Diagonal 1
		for (int i = 0; i < n; i++) {
			if (board[i][i] != piece) {
				break;
			}
			if (i == n - 1) {
				return "WON";
			}
		}

		// Checking Diagonal 2
		for (int i = 0; i < n; i++) {
			if (board[i][n - i - 1] != piece) {
				break;
			}
			if (i == n - 1) {
				return "WON";
			}
		}

		this.remainingPositions--;

		return this.remainingPositions == 0 ? "DRAW" : "CONTINUE";
	}

	public void resetBoard() {
		int n = board.length;
		this.remainingPositions = n * n;
		board = new PlayingPiece[n][n];
	}

}
