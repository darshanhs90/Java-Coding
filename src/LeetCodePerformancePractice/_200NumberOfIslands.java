package LeetCodePerformancePractice;

public class _200NumberOfIslands {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {


	}
	static boolean[][] visited;
	public int numIslands(char[][] grid) {
		if(grid==null||grid.length==0)
			return 0;
		int count=0;
		visited=new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(!visited[i][j] && grid[i][j]=='1')
					count+=findIsland(i,j,grid)+1;
			}
		}
		return count;
	}
	private int findIsland(int i, int j, char[][] grid) {
		if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||visited[i][j]||grid[i][j]=='0')
			return 0;
		visited[i][j]=true;
		return findIsland(i-1, j, grid)+findIsland(i+1, j, grid)+findIsland(i, j+1, grid)+findIsland(i, j-1, grid);
	}
}
