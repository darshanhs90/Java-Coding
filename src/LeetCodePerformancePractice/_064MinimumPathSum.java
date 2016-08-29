package LeetCodePerformancePractice;

public class _064MinimumPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}	
	public static int minPathSum(int[][] grid) {
		return findSum(0,0,grid,0);
	}
	private static int findSum(int i, int j, int[][] grid,int sum) {
		if(i<0||j<0||i>=grid.length||j>=grid[0].length)
			return Integer.MAX_VALUE;
		if(i==grid.length-1 && j==grid[0].length-1)
			return sum+grid[i][j];
		return Math.min(findSum(i+1, j, grid, sum+grid[i][j]), findSum(i, j+1, grid, sum+grid[i][j]));
	}
}

