package PracticeLeetCode;

public class _079WordSearch {
	public static void main(String[] args) {
		System.out.println(exist(new char[][]{  
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}}, "SEE"));
	}
	public static boolean exist(char[][] board, String word) {
		if(board==null||board.length==0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(wordExists(i,j,0,board,word))
					return true;
			}
		}
		return false;
	}
	private static boolean wordExists(int i, int j, int index, char[][] board, String word) {
		if(index>word.length()||i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='#')
			return false;
		if(board[i][j]==word.charAt(index) && index==word.length()-1)
			return true;
		else{
			if(board[i][j]==word.charAt(index)){
				char temp=board[i][j];
				board[i][j]='#';
				if(wordExists(i+1, j, index+1, board, word)||wordExists(i-1, j, index+1, board, word)
						||wordExists(i, j+1, index+1, board, word)||wordExists(i, j-1, index+1, board, word))
				{
					return true;
				}
				board[i][j]=temp;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
