package LeetCodePerformancePractice;

public class _064MinimumPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}	
	public static int minPathSum(int[][] grid) {
		return findPathSum(0,0,grid,0);
	}
	private static int findPathSum(int i, int j, int[][] matrix,int currSum) {
		if(i<0||j<0||i>matrix.length-1||j>matrix[0].length-1)
			return Integer.MAX_VALUE;
		if(i==matrix.length-1 && j==matrix[0].length-1)
			return currSum+matrix[i][j];
		return Math.min(findPathSum(i+1, j, matrix, currSum+matrix[i][j]),findPathSum(i, j+1, matrix, currSum+matrix[i][j]));
	}
}

