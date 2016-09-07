package LeetCodePerformancePractice;

public class _079WordSearch {
	public static void main(String[] args) {
		System.out.println(exist(new char[][]{  
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}}, "SEE"));
	}
	public static boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(wordExists(i,j,board,0,word))
					return true;
			}
		}
		return false;
	}
	private static boolean wordExists(int i, int j, char[][] board,int index, String word) {
		if(i<0||j<0||i>=board.length||j>=board[0].length)
			return false;
		if(board[i][j]==word.charAt(index))
		{
			if(index==word.length()-1)
				return true;
			char temp=board[i][j];
			board[i][j]='#';
			if(wordExists(i+1, j, board, index+1, word)
					||wordExists(i-1, j, board, index+1, word)
					||wordExists(i, j+1, board, index+1, word)
					||wordExists(i, j-1, board, index+1, word))
				return true;
			board[i][j]=temp;
		}
		return false;
	}
}
