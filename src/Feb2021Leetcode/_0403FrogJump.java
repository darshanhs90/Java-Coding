package Feb2021Leetcode;

import java.util.HashMap;

public class _0403FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public static boolean canCross(int[] stones) {
		if (stones == null || stones.length < 2)
			return true;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
		}
		return canJump(0, 0, map, stones[stones.length - 1]);
	}

	public static boolean canJump(int jump, int currVal, HashMap<Integer, Integer> map, int maxVal) {
		if (!map.containsKey(currVal) || currVal > maxVal)
			return false;

		if (map.get(currVal) == map.size() - 1)
			return true;

		boolean out = false;
		if (jump - 1 > 0 && map.containsKey(currVal + jump - 1)) {
			out = canJump(jump - 1, currVal + jump - 1, map, maxVal);
		}
		if (out)
			return true;
		if (jump > 0 && map.containsKey(currVal + jump)) {
			out = canJump(jump, currVal + jump, map, maxVal);
		}
		if (out)
			return true;
		if (map.containsKey(currVal + jump + 1)) {
			out = canJump(jump + 1, currVal + jump + 1, map, maxVal);
		}
		return out;
	}

}
