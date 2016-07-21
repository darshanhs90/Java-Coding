package LeetCodePractice;

public class _064MinimumPathSum {


	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1,2,3},
													{4,5,6},
													{7,8,9}}));
	}


	public static int minPathSum(int[][] obstacleGrid) {
		return findPaths(0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,0);
	}

	static int minValue=Integer.MAX_VALUE;
	private static int findPaths(int i, int j,int m,int n, int[][] obstacleGrid,int sum) {
		if(i==m && j==n){
			return Math.min(minValue, sum+obstacleGrid[i][j]);
		}
		if(i<0 || j<0 || i>m||j>n)
			return Integer.MAX_VALUE;
		return Math.min(findPaths(i+1, j, m, n, obstacleGrid,sum+obstacleGrid[i][j]),findPaths(i, j+1, m, n, obstacleGrid,sum+obstacleGrid[i][j]));
	}

}

