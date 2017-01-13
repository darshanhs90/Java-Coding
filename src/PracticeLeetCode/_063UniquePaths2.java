package PracticeLeetCode;

public class _063UniquePaths2 {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{
			{0,0,0},
			{0,1,0},
			{0,0,0}}));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null||obstacleGrid.length==0)
			return 0;
		return dfs(0,0,obstacleGrid);
	}

	private static int dfs(int i, int j, int[][] obstacleGrid) {
		if(i<0||j<0||i>obstacleGrid.length-1||j>obstacleGrid[0].length-1||obstacleGrid[i][j]==1)
			return 0;
		if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1)
			return 1;
		return dfs(i+1, j, obstacleGrid)+dfs(i, j+1, obstacleGrid);
	}
}

