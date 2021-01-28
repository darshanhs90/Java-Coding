package LeetcodeTemplate;

public class _0348DesignTicTacToe {

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe(3);
		/*
		 * Assume that player 1 is "X" and player 2 is "O" in the board.
		 * ticTacToe.move(0, 0, 1); // return 0 (no one wins) |X| | | | | | | // Player
		 * 1 makes a move at (0, 0). | | | |
		 */

		System.out.println(ticTacToe.move(0, 2, 2)); // return 0 (no one wins)
		/*
		 * |X| |O| | | | | // Player 2 makes a move at (0, 2). | | | |
		 */

		System.out.println(ticTacToe.move(2, 2, 1)); // return 0 (no one wins)
		/*
		 * |X| |O| | | | | // Player 1 makes a move at (2, 2). | | |X|
		 */

		System.out.println(ticTacToe.move(1, 1, 2)); // return 0 (no one wins)
		/*
		 * |X| |O| | |O| | // Player 2 makes a move at (1, 1). | | |X|
		 */

		System.out.println(ticTacToe.move(2, 0, 1)); // return 0 (no one wins)
		/*
		 * |X| |O| | |O| | // Player 1 makes a move at (2, 0). |X| |X|
		 */

		System.out.println(ticTacToe.move(1, 0, 2)); // return 0 (no one wins)
		/*
		 * |X| |O| |O|O| | // Player 2 makes a move at (1, 0). |X| |X|
		 */

		System.out.println(ticTacToe.move(2, 1, 1)); // return 1 (player 1 wins)
		/*
		 * |X| |O| |O|O| | // Player 1 makes a move at (2, 1). |X|X|X|
		 */
	}

	static class TicTacToe {

		/** Initialize your data structure here. */
		public TicTacToe(int n) {

		}

		/**
		 * Player {player} makes a move at ({row}, {col}).
		 * 
		 * @param row    The row of the board.
		 * @param col    The column of the board.
		 * @param player The player, can be either 1 or 2.
		 * @return The current winning condition, can be either: 0: No one wins. 1:
		 *         Player 1 wins. 2: Player 2 wins.
		 */
		public int move(int row, int col, int player) {
		
		}

		public int checkWinner(int[][] board, int player) {
		
		}
	}

}
