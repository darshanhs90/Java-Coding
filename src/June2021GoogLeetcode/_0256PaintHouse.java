package June2021GoogLeetcode;

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
			int val1 = dp[0];
			int val2 = dp[1];
			int val3 = dp[2];

			dp[0] = costs[i][0] + Math.min(val2, val3);
			dp[1] = costs[i][1] + Math.min(val1, val3);
			dp[2] = costs[i][2] + Math.min(val1, val2);
		}
		return Math.min(dp[0], Math.min(dp[1], dp[2]));
	}

}
