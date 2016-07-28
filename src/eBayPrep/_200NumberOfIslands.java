package eBayPrep;

public class _200NumberOfIslands {
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}}));
		System.out.println(numIslands(new char[][]{
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}}));
	}
	static boolean[][] visited;
	private static int numIslands(char[][] cs) {
		if(cs==null||cs.length==0)
			return 0;
		visited=new boolean[cs.length][cs[0].length];
		int count=0;
		for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < cs[0].length; j++) {
				if(!visited[i][j] && cs[i][j]=='1')
					count+=findIslands(i,j,cs)>0?1:0;
			}
		}
		return count;
	}
	private static int findIslands(int i, int j, char[][] cs) {
		if(i<0||j<0||i>cs.length-1||j>cs[0].length-1||visited[i][j]||cs[i][j]=='0')
			return 0;
		visited[i][j]=true;
		return 1+findIslands(i+1, j, cs)+findIslands(i-1, j, cs)+findIslands(i, j+1, cs)+findIslands(i, j-1, cs);
	}



}

