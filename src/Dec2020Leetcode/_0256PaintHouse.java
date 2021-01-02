package Dec2020Leetcode;

public class _0256PaintHouse {

	public static void main(String[] args) {
		System.out.println(
				minCost(new int[][] { new int[] { 17, 2, 17 }, new int[] { 16, 16, 5 }, new int[] { 14, 3, 19 } }));
		System.out.println(minCost(new int[][] {}));
		System.out.println(minCost(new int[][] { new int[] { 7, 6, 2 } }));
	}

	public static int minCost(int[][] costs) {
		if (costs.length == 0)
			return 0;
		for (int i = costs.length - 1; i >= 1; i--) {
			costs[i - 1][0] += Math.min(costs[i][1], costs[i][2]);
			costs[i - 1][1] += Math.min(costs[i][0], costs[i][2]);
			costs[i - 1][2] += Math.min(costs[i][0], costs[i][1]);
		}

		return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
	}

}
