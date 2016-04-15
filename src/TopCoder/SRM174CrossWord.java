package TopCoder;

/*
 * SRM 173 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1975&rd=4670
 */



public class SRM174CrossWord {
	public static void main(String[] args) {
		System.out.println(countWords(new String[]{"X....X",
				"X.XX.X",
				"...X..",
				"X.XX.X",
		"..X..."},3));
		System.out.println(countWords(new String[]{"...X...",
				".X...X.",
				"..X.X..",
				"X..X..X",
				"..X.X..",
				".X...X.",
		"...X..."},3));
		System.out.println(countWords(new String[]{".....X....X....",
				".....X....X....",
				"..........X....",
				"....X....X.....",
				"...X....X....XX",
				"XXX...X....X...",
				".....X....X....",
				".......X.......",
				"....X....X.....",
				"...X....X...XXX",
				"XX....X....X...",
				".....X....X....",
				"....X..........",
				"....X....X.....",
		"....X....X....."},5));
		System.out.println(countWords(new String[]{"...",
				"...",
		"..."},50));
		System.out.println(countWords(new String[]{"....",
				"....",
		"...."},3));
		System.out.println(countWords(new String[]{".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", ".......................................", "......................................."}, 39));
	}
	public static int countWords(String[] board, int size){
		int count=0;
		if(size>board[0].length())
			return 0;
		boolean equalflag=false;
		if(size==board[0].length())
			equalflag=true;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(".");
		}
		String pattern=sb.toString();
		for (int i = 0; i < board.length; i++) {
			String boardString=board[i];
			if(equalflag){
				if(boardString.contentEquals(pattern))
					count++;
				continue;
			}
			if(boardString.indexOf(pattern)==-1)
				continue;
			int index=boardString.indexOf(pattern);

			while(index!=-1){
				if(index==0)
				{	
					if(boardString.substring(0,size+1).contentEquals(pattern+"X"))
						count++;
				}else if((index+size)==boardString.length()){
					if(boardString.substring(index-1).contentEquals("X"+pattern))
						count++;
				}else{
					if(boardString.substring(index-1,index+size+1).contentEquals("X"+pattern+"X"))
						count++;
				}
				index=boardString.indexOf(pattern, index+size-1);
			}
		}
		return count;
	}
}
