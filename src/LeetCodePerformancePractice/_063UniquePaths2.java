package LeetCodePerformancePractice;

public class _063UniquePaths2 {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{
			{0,0,0},
			{0,1,0},
			{0,0,0}}));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return countPaths(0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);
	}

	private static int countPaths(int row, int col, int maxRow, int maxCol, int[][] obstacleGrid) {
		if(row<0||col<0||row>maxRow||col>maxCol||obstacleGrid[row][col]==1)
			return 0;
		if(row==maxRow && col==maxCol)
			return 1;
		return countPaths(row+1, col, maxRow, maxCol, obstacleGrid)+countPaths(row, col+1, maxRow, maxCol, obstacleGrid);
	}
}

