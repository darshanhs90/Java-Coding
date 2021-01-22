package Dec2020Leetcode;

public class _1029TwoCityScheduling {
	public static void main(String[] args) {
		System.out.println(twoCitySchedCost(new int[][] { new int[] { 10, 20 }, new int[] { 30, 200 },
				new int[] { 400, 50 }, new int[] { 30, 20 } }));

		System.out.println(twoCitySchedCost(new int[][] { new int[] { 259, 770 }, new int[] { 448, 54 },
				new int[] { 926, 667 }, new int[] { 184, 139 }, new int[] { 840, 118 }, new int[] { 577, 469 } }));
		System.out.println(twoCitySchedCost(new int[][] { new int[] { 515, 563 }, new int[] { 451, 713 },
				new int[] { 537, 709 }, new int[] { 343, 819 }, new int[] { 855, 779 }, new int[] { 457, 60 },
				new int[] { 650, 359 }, new int[] { 631, 42 } }));
	}

	static int minSum = Integer.MAX_VALUE;

	public static int twoCitySchedCost(int[][] costs) {
		minSum = Integer.MAX_VALUE;
		dfs(0, 0, 0, 0, costs);
		return minSum;
	}

	public static void dfs(int index, int currSum, int left, int right, int[][] costs) {
		if (currSum > minSum)
			return;
		if (index == costs.length) {
			if (left == right) {
				minSum = Math.min(currSum, minSum);
			}
			return;
		}
		if (currSum + costs[index][0] < minSum)
			dfs(index + 1, currSum + costs[index][0], left + 1, right, costs);
		if (currSum + costs[index][1] < minSum)
			dfs(index + 1, currSum + costs[index][1], left, right + 1, costs);
	}

}
