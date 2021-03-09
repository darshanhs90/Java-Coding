package Feb2021Leetcode;

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
		return canCross(0, 0, 0, stones, map);
	}

	public static boolean canCross(int index, int val, int jump, int[] stones, HashMap<Integer, Integer> map) {
		if (index == stones.length - 1)
			return true;

		boolean out = false;
		if (jump - 1 > 0 && map.containsKey(jump - 1 + val)) {
			out = canCross(map.get(jump - 1 + val), jump - 1 + val, jump - 1, stones, map);
		}
		if (out)
			return true;

		if (jump > 0 && map.containsKey(jump + val)) {
			out = canCross(map.get(jump + val), jump + val, jump, stones, map);
		}
		if (out)
			return true;
		if (map.containsKey(jump + 1 + val)) {
			out = canCross(map.get(jump + 1 + val), jump + 1 + val, jump + 1, stones, map);
		}
		return out;
	}

}
