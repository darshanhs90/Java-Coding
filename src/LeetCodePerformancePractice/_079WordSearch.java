package LeetCodePerformancePractice;

public class _079WordSearch {
	public static void main(String[] args) {

	}
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(foundWord(i,j,board,word,0))
					return true;
			}
		}
		return false;
	}
	private static boolean foundWord(int i, int j, char[][] board, String word,int index) {
		if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index))
			return false;
		if(index==word.length()-1)
			return true;
		char temp=board[i][j];
		board[i][j]='#';
		if( foundWord(i+1, j, board, word,index+1)
				||foundWord(i-1, j, board, word,index+1)
				||foundWord(i, j+1, board, word,index+1)
				||foundWord(i, j-1, board, word,index+1))
			return true;
		board[i][j]=temp;
		return false;
	}
}
