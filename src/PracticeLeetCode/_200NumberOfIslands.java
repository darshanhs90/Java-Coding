package PracticeLeetCode;

public class _200NumberOfIslands {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}	
		}));

	}
	public static int numIslands(char[][] grid) {
		if(grid==null||grid.length==0)
			return 0;
		int count=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]=='1'){
					dfs(i,j,grid);
					count+=1;
				}
			}
		}
		return count;
	}
	private static void dfs(int i, int j, char[][] grid) {
		if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!='1')
			return;
		grid[i][j]='#';
		dfs(i+1, j, grid);
		dfs(i-1, j, grid);
		dfs(i, j+1, grid);
		dfs(i, j-1, grid);
	}
}