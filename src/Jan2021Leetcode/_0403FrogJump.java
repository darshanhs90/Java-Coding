package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0403FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public static boolean canCross(int[] stones) {
		int[][] dp = new int[stones.length][stones.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
			Arrays.fill(dp[i], -1);
		}

		return dfs(0, 0, stones, dp, map);
	}

	public static boolean dfs(int index, int jumpSize, int[] stones, int[][] dp, HashMap<Integer, Integer> map) {
		if (index == stones.length - 1 || dp[index][jumpSize] == 1)
			return true;

		if (dp[index][jumpSize] == 0)
			return false;

		boolean val = false;
		if (jumpSize - 1 > 0 && map.containsKey(stones[index] + jumpSize - 1)) {
			int newIndex = map.get(stones[index] + jumpSize - 1);
			val = dfs(newIndex, jumpSize - 1, stones, dp, map);
		}

		if (jumpSize > 0 && map.containsKey(stones[index] + jumpSize)) {
			int newIndex = map.get(stones[index] + jumpSize);
			val = val || dfs(newIndex, jumpSize, stones, dp, map);
		}

		if (jumpSize + 1 > 0 && map.containsKey(stones[index] + jumpSize + 1)) {
			int newIndex = map.get(stones[index] + jumpSize + 1);
			val = val || dfs(newIndex, jumpSize + 1, stones, dp, map);
		}

		dp[index][jumpSize] = val == true ? 1 : 0;
		return val;
	}

}
