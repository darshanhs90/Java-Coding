package PracticeLeetCode;

public class _079WordSearch {
	public static void main(String[] args) {
		System.out.println(exist(new char[][]{  
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}}, "SNE"));
	}
	public static boolean exist(char[][] board, String word) {
		if(board==null||board.length==0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(containsWord(i,j,0,board,word))
					return true;
			}
		}
		return false;
	}
	private static boolean containsWord(int i, int j,int index,char[][] board, String word) {
		if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='#'||board[i][j]!=word.charAt(index))	
			return false;
		if(index==word.length()-1)
			return true;
		char temp=board[i][j];
		board[i][j]='#';
		if(containsWord(i+1, j, index+1, board, word)
				||containsWord(i-1, j, index+1, board, word)
				||containsWord(i, j+1, index+1, board, word)
				||containsWord(i, j-1, index+1, board, word))
			return true;
		board[i][j]=temp;
		return false;
	}
}
