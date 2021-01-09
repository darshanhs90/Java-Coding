package Dec2020Leetcode;

public class _0746MinCostClimbingStairs {
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public static int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < dp.length; i++) {
			int currVal = i < cost.length ? cost[i] : 0;
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + currVal;
		}
		return dp[dp.length - 1];
	}
}
