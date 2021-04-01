package Mar2021Leetcode;

import java.util.HashMap;

public class _0403FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	public static boolean canCross(int[] stones) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
		}
		return canCross(0, 0, map);
	}

	public static boolean canCross(int jump, int currVal, HashMap<Integer, Integer> map) {
		if (map.containsKey(currVal) && map.get(currVal) == map.size() - 1)
			return true;

		if (!map.containsKey(currVal))
			return false;

		boolean out = false;
		if (jump > 0 && map.containsKey(currVal + jump)) {
			out = canCross(jump, currVal + jump, map);
		}
		if (out)
			return true;

		if (jump - 1 > 0 && map.containsKey(currVal + jump - 1)) {
			out = canCross(jump - 1, currVal + jump - 1, map);
		}
		if (out)
			return true;

		if (jump + 1 > 0 && map.containsKey(currVal + jump + 1)) {
			out = canCross(jump + 1, currVal + jump + 1, map);
		}
		return out;
	}

}
