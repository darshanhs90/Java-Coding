package SnapPrep;

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

	public static boolean canCross(int jump, int value, HashMap<Integer, Integer> map) {
		if (map.get(value) == map.size() - 1)
			return true;

		if (jump > 0 && map.containsKey(value + jump)) {
			if (canCross(jump, value + jump, map))
				return true;
		}

		if (jump - 1 > 0 && map.containsKey(value + jump - 1)) {
			if (canCross(jump - 1, value + jump - 1, map))
				return true;
		}
		if (jump + 1 > 0 && map.containsKey(value + jump + 1)) {
			if (canCross(jump + 1, value + jump + 1, map))
				return true;
		}
		return false;
	}

}
