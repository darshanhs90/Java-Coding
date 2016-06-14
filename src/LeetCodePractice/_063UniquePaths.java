package LeetCodePractice;

public class _063UniquePaths {


	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
	}


	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return findPaths(0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);
	}


	private static int findPaths(int i, int j,int m,int n, int[][] obstacleGrid) {
		if(i==m && j==n)
			return 1;
		if(i<0 || j<0 || i>m||j>n||obstacleGrid[i][j]==1)
			return 0;
		return findPaths(i+1, j, m, n, obstacleGrid)+findPaths(i, j+1, m, n, obstacleGrid);
	}

}

