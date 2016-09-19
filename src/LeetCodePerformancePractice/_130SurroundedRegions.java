package LeetCodePerformancePractice;

public class _130SurroundedRegions {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public void solve(char[][] board) {
		if(board==null||board.length==0)
			return;
		//right and left border
		for (int i = 0; i < board.length; i++) {
			if(board[i][0]=='O')
				mergeboard(board,i,0);
			if(board[i][board[0].length-1]=='O')
				mergeboard(board,i,board[0].length-1);
		}
		for (int i = 0; i < board[0].length; i++) {
			if(board[0][i]=='O')
				mergeboard(board,0,i);
			if(board[board.length-1][i]=='O')
				mergeboard(board,board.length-1,i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]=='O')
					board[i][j]='X';
				else if(board[i][j]=='#')
					board[i][j]='O';
			}
		}
	}
	private void mergeboard(char[][] board, int i, int j) {
		if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!='O')
			return;
		board[i][j]='#';
		mergeboard(board, i+1, j);
		mergeboard(board, i-1, j);
		mergeboard(board, i, j+1);
		mergeboard(board, i, j-1);
	}
}
