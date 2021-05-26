package May2021GoogLeetcode;

public class _0256PaintHouse {

	public static void main(String[] args) {
		System.out.println(
				minCost(new int[][] { new int[] { 17, 2, 17 }, new int[] { 16, 16, 5 }, new int[] { 14, 3, 19 } }));
		System.out.println(minCost(new int[][] {}));
		System.out.println(minCost(new int[][] { new int[] { 7, 6, 2 } }));
	}

	public static int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;
		int[] dp = new int[3];
		dp[0] = costs[0][0];
		dp[1] = costs[0][1];
		dp[2] = costs[0][2];

		for (int i = 1; i < costs.length; i++) {
			int cost0 = dp[0];
			int cost1 = dp[1];
			int cost2 = dp[2];

			dp[0] = Math.min(cost1, cost2) + costs[i][0];
			dp[1] = Math.min(cost0, cost2) + costs[i][1];
			dp[2] = Math.min(cost0, cost1) + costs[i][2];
		}

		return Math.min(dp[0], Math.min(dp[1], dp[2]));
	}

}
