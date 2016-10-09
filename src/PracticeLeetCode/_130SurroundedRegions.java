package PracticeLeetCode;

import java.util.Arrays;

public class _130SurroundedRegions {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		solve(new char[][]{
			{'X','X','X','X'},
			{'X','O','O','X'},
			{'X','X','O','X'},
			{'X','O','X','X'}});
	}
	public static void solve(char[][] board) {
		if(board==null||board.length==0)
			return;
		for (int i = 0; i < board[0].length; i++) {
			if(board[0][i]=='O')
			{
				floodFill(0,i,board);
			}
			if(board[board.length-1][i]=='O')
			{
				floodFill(board.length-1,i,board);
			}
		}
		for (int i = 0; i < board.length; i++) {
			if(board[i][0]=='O')
			{
				floodFill(i,0,board);
			}
			if(board[i][board[0].length-1]=='O')
			{
				floodFill(i,board[0].length-1,board);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]=='O')
					board[i][j]='X';
				else if(board[i][j]=='#')
					board[i][j]='O';
			}
		}
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}
	private static void floodFill(int i, int j, char[][] board) {
		if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!='O')
			return;
		board[i][j]='#';
		floodFill(i+1, j, board);
		floodFill(i-1, j, board);
		floodFill(i, j+1, board);
		floodFill(i, j-1, board);
	}
}
