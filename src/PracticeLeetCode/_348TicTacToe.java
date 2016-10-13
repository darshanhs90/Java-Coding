package PracticeLeetCode;

public class _348TicTacToe {

	int[][] matrix;a

	/** Initialize your data structure here. */
	public _348TicTacToe(int n) {
		matrix = new int[n][n];
	}

	/** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	public int move(int row, int col, int player) {
		matrix[row][col]=player;

		//check row
		boolean win=true;
		for(int i=0; i<matrix.length; i++){
			if(matrix[row][i]!=player){
				win=false;
				break;
			}
		}

		if(win) return player;

		//check column
		win=true;
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][col]!=player){
				win=false;
				break;
			}
		}

		if(win) return player;

		//check back diagonal
		win=true;
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][i]!=player){
				win=false;
				break;
			}
		}

		if(win) return player;

		//check forward diagonal
		win=true;
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][matrix.length-i-1]!=player){
				win=false;
				break;
			}
		}

		if(win) return player;

		return 0;
	}
}
