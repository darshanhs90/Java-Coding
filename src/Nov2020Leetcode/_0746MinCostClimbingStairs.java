package Nov2020Leetcode;

public class _0746MinCostClimbingStairs {
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public static int minCostClimbingStairs(int[] cost) {
		int[] climbingCost = new int[cost.length];
		climbingCost[0] = cost[0];
		climbingCost[1] = cost[1];
		for (int i = 2; i < climbingCost.length; i++) {
			climbingCost[i] = cost[i] + Math.min(climbingCost[i - 1], climbingCost[i - 2]);
		}

		return Math.min(climbingCost[climbingCost.length - 1], climbingCost[climbingCost.length - 2]);
	}
}
