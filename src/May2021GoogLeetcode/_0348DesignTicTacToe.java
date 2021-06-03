package May2021GoogLeetcode;

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
		
	}

}
