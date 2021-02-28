package FacebookPrep;

import java.util.Arrays;
import java.util.HashMap;

public class _0403FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public static boolean canCross(int[] stones) {
		if (stones == null || stones.length < 2)
			return true;
		int[][] dp = new int[stones.length][stones.length];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
			Arrays.fill(dp[i], -1);
		}
		return canJump(0, 0, dp, stones, map);
	}

	public static boolean canJump(int index, int jump, int[][] dp, int[] stones, HashMap<Integer, Integer> map) {
		if (index == stones.length - 1 || dp[index][jump] == 1)
			return true;

		if (dp[index][jump] == 0)
			return false;
		boolean out = false;
		if (jump > 0 && map.containsKey(jump + stones[index])) {
			int newIndex = map.get(jump + stones[index]);
			out = out || canJump(newIndex, jump, dp, stones, map);
		}

		if (!out && jump - 1 > 0 && map.containsKey(jump + stones[index] - 1)) {
			int newIndex = map.get(jump + stones[index] - 1);
			out = out || canJump(newIndex, jump - 1, dp, stones, map);
		}

		if (!out && map.containsKey(jump + stones[index] + 1)) {
			int newIndex = map.get(jump + stones[index] + 1);
			out = out || canJump(newIndex, jump + 1, dp, stones, map);
		}

		dp[index][jump] = out == true ? 1 : 0;
		return out;
	}

}
