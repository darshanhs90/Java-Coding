package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
public class _0133LongestPathProblemDP {
	public static void main(String[] args) {
		int cost[][] = {{1, 2, 9},
				{5, 3, 8},
				{4, 6, 7}};

		System.out.println(findMaxLength(cost));
	}

	private static int findMaxLength(int[][] cost) {
		int maxValue=1;
		int[][] dp= new int[cost.length][cost[0].length];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],-1);
		}
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				if(dp[i][j]==-1)
					findLongestFromThisCell(i,j,cost,dp);
				maxValue=Math.max(maxValue, dp[i][j]);
			}
		}
		return maxValue;
	}

	private static int findLongestFromThisCell(int i, int j, int[][] cost, int[][] dp) {
		if(i<0 || i>cost.length-1||j<0||j>cost[0].length-1)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if ((cost[i][j] +1) == cost[i][j+1])
			return dp[i][j] = 1 + findLongestFromThisCell(i,j+1,cost,dp);
		if (cost[i][j] +1 == cost[i][j-1])
			return dp[i][j] = 1 + findLongestFromThisCell(i,j-1,cost,dp);
		if (cost[i][j] +1 == cost[i-1][j])
			return dp[i][j] = 1 + findLongestFromThisCell(i-1,j,cost,dp);
		if (cost[i][j] +1 == cost[i+1][j])
			return dp[i][j] = 1 + findLongestFromThisCell(i+1,j,cost,dp);
		return dp[i][j] = 1;
	}

}
