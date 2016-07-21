package LeetCodePractice;

public class _200NumberOfIslands {
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},
												{'1','1','0','1','0'},
												{'1','1','0','0','0'},
												{'0','0','0','0','0'}}));
		System.out.println(numIslands(new char[][]{{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}}));
	}
	static boolean[][] visited;
	public static int numIslands(char[][] grid) {
		int count=0;
		if(grid.length==0)
			return 0;
		visited=new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(!visited[i][j] && grid[i][j]=='1'){
					captureGrid(grid,i,j);
					count++;
				}
			}
		}
		return count;
	}
	private static  void captureGrid(char[][] grid, int i, int j) {
		if(i<0||i>grid.length-1||j<0||j>grid[0].length-1)
			return;
		if(grid[i][j]=='0' || visited[i][j])return;
		visited[i][j]=true;
		captureGrid(grid, i-1, j);
		captureGrid(grid, i+1, j);
		captureGrid(grid, i, j-1);
		captureGrid(grid, i, j+1);
	}
}

