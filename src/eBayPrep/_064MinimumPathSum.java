package eBayPrep;

public class _064MinimumPathSum {


	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}


	public static int minPathSum(int[][] obstacleGrid) {
		return dfs(0,0,obstacleGrid,0);
	}


	private static int dfs(int i, int j, int[][] obstacleGrid, int sum) {
		if(i<0||j<0||i>=obstacleGrid.length||j>=obstacleGrid[0].length)
			return Integer.MAX_VALUE;
		if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1)
			return sum+obstacleGrid[i][j];
		return Math.min(dfs(i+1, j, obstacleGrid, sum+obstacleGrid[i][j]), dfs(i, j+1, obstacleGrid, sum+obstacleGrid[i][j]));
	}


}

