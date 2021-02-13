package Jan2021Leetcode;

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
		for (int i = 1; i < costs.length; i++) {
			int currVal0 = costs[i][0];
			int currVal1 = costs[i][1];
			int currVal2 = costs[i][2];
			costs[i][0] = currVal0 + Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] = currVal1 + Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] = currVal2 + Math.min(costs[i - 1][0], costs[i - 1][1]);
		}

		int len = costs.length - 1;
		return Math.min(costs[len][0], Math.min(costs[len][1], costs[len][2]));
	}

}
