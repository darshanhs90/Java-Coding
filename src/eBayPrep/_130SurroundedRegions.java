package LeetCodePractice;

import java.util.Arrays;

public class _130SurroundedRegions {

	public static void main(String[] args) {
		solve(new char[][]{{'X','X','X','X'},
							{'X','O','O','X'},
							{'X','X','O','X'},
							{'X','O','X','X'}});
	}
	public static void solve(char[][] board) {
		for (int i = 1; i < board.length-1; i++) {
			for (int j = 1; j < board[0].length-1; j++) {
				if(board[i][j]=='O')
				{
					if(checkCell(board,i,j))
						board[i][j]='X';
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	private static boolean checkCell(char[][] board, int i, int j) {
		if(i<0||i>board.length-1 || j<0 || j>board[0].length-1)
			return false;
		if(board[i][j]=='X'||(board[i-1][j]=='X' && board[i+1][j]=='X' && board[i][j-1]=='X'&& board[i][j+1]=='X'))
			return true;
		return checkCell(board, i-1, j) && checkCell(board, i+1, j) &&checkCell(board, i, j-1) &&checkCell(board, i, j+1) ;
	}
}

