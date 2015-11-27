package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/validity-of-a-given-tic-tac-toe-board-configuration/
 */
public class _0083TicTacToeValidity {

	public static void main(String[] args) {
		char board[] = {'X', 'X', 'O',
				'O', 'O', 'X',
				'X', 'O', 'X'};
		System.out.println(checkValidity(board));
	}
	static int winMatrix[][]=new int[][]{{0, 1, 2}, // Check first row.
		{3, 4, 5}, // Check second Row
		{6, 7, 8}, // Check third Row
		{0, 3, 6}, // Check first column
		{1, 4, 7}, // Check second Column
		{2, 5, 8}, // Check third Column
		{0, 4, 8}, // Check first Diagonal
		{2, 4, 6}};


		private static boolean checkValidity(char[] board) {
			//getXcount
			//getOcount
			boolean xWin=checkWin(board,'X');
			boolean oWin=checkWin(board,'O');
			int xCount=0,oCount=0;
			for (int i = 0; i < board.length; i++) {
				if(board[i]=='X')
					xCount++;
				else if(board[i]=='O')
					oCount++;
			}

			if(xCount==oCount||xCount==oCount+1)
			{
				if(oWin)
				{
					if(xWin){
						return false;
					}
					if(xCount==oCount)
						return true;
					else
						return false;
				}
			}

			if(xWin && xCount!=oCount+1)
				return false;
			return true;
		}



		private static boolean checkWin(char[] board, char c) {
			for (int i = 0; i < winMatrix.length; i++) {
				if(board[winMatrix[i][0]]=='c'
						&& board[winMatrix[i][1]]=='c'
						&& board[winMatrix[i][2]]=='c')
					return true;
			}
			return false;

		}



		/*private static void printMatrix(int[][] s) {
			for (int i = 0; i < s.length; i++) {
				System.out.println(Arrays.toString(s[i]));
			}

		}
*/

}
