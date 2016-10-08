package PracticeLeetCode;

public class _064MinimumPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}	
	public static int minPathSum(int[][] grid) {
		return findMinPathSum(0,0,0,grid);
	}
	private static int findMinPathSum(int i, int j, int sum, int[][] grid) {
		if(i<0||j<0||i>grid.length-1||j>grid[0].length-1)
			return Integer.MAX_VALUE;
		if(i==grid.length-1 && j==grid[0].length-1)
			return sum+grid[i][j];
		return Math.min(findMinPathSum(i+1, j, sum+grid[i][j], grid), findMinPathSum(i, j+1, sum+grid[i][j], grid));
	}
}

