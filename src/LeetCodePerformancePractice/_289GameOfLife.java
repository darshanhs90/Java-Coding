package LeetCodePerformancePractice;

import java.util.Arrays;

public class _289GameOfLife {
	public static void main(String[] args) {
		gameOfLife(new int[][]{
			{0,0,0,0,0},
			{0,0,1,0,0},
			{0,0,1,0,0},
			{0,0,1,0,0},
			{0,0,0,0,0}});
	}
	public static void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//present live->next live=>2
				//present live->next dead=>3
				//present dead->next live=>4
				board[i][j]=getUpdatedValue(i,j,board);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j]=(board[i][j]==0 || board[i][j]==3)?0:1;
			}
		}
	}
	private static int getUpdatedValue(int i, int j, int[][] board) {
		int count=0;
		int m=board.length,n=board[0].length;
		//present live cell
		//i-1,j-1
		if(i-1>=0 && j-1>=0 && (board[i-1][j-1]==1||board[i-1][j-1]==2||board[i-1][j-1]==3))
			count++;
		//i,j-1
		if(i>=0 && j-1>=0 && (board[i][j-1]==1||board[i][j-1]==2||board[i][j-1]==3))
			count++;
		//i+1,j-1
		if(i+1<m && j-1>=0 && (board[i+1][j-1]==1||board[i+1][j-1]==2||board[i+1][j-1]==3))
			count++;
		//i-1,j
		if(i-1>=0 && j>=0 && (board[i-1][j]==1||board[i-1][j]==2||board[i-1][j]==3))
			count++;
		//i+1,j
		if(i+1<m && j>=0 && (board[i+1][j]==1||board[i+1][j]==2||board[i+1][j]==3))
			count++;
		//i-1,j+1
		if(i-1>=0 && j+1<n && (board[i-1][j+1]==1||board[i-1][j+1]==2||board[i-1][j+1]==3))
			count++;
		//i,j+1
		if(i>=0 && j+1<n && (board[i][j+1]==1||board[i][j+1]==2||board[i][j+1]==3))
			count++;
		//i+1,j+1
		if(i+1<m && j+1<n && (board[i+1][j+1]==1||board[i+1][j+1]==2||board[i+1][j+1]==3))
			count++;
		if(board[i][j]==1)
		{
			if(count<2||count>3)
				return 3;
			else if(count>=2 && count<=3)
				return 1;
		}
		else {
			if(count==3)
				return 4;
		}
		return board[i][j];
	}
}
