package PracticeLeetCode;

public class _079WordSearch {
	public static void main(String[] args) {
		System.out.println(exist(new char[][]{  
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}}, "SEEN"));
	}
	public static boolean exist(char[][] board, String word) {
		if(board==null||board.length==0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(exists(0,i,j,board,word))
					return true;
			}
		}
		return false;
	}
	private static boolean exists(int index, int i, int j, char[][] board, String word) {
		if(index>word.length()-1||i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='#')
			return false;
		if(index==word.length()-1 && board[i][j]==word.charAt(index))
			return true;
		if(board[i][j]==word.charAt(index)){
			char temp=board[i][j];
			board[i][j]='#';
			if(exists(index+1, i+1, j, board, word)
					||exists(index+1, i-1, j, board, word)
					||exists(index+1, i, j+1, board, word)
					||exists(index+1, i, j-1, board, word))
				return true;
			board[i][j]=temp;
		}
		return false;
	}
}
