package June2021GoogLeetcode;

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

	public static boolean canCross(int jump, int val, HashMap<Integer, Integer> map) {
		if (map.get(val) == map.size() - 1)
			return true;

		if (jump > 0 && map.containsKey(jump + val)) {
			if (canCross(jump, jump + val, map))
				return true;
		}

		if (jump - 1 > 0 && map.containsKey(jump - 1 + val)) {
			if (canCross(jump - 1, jump - 1 + val, map))
				return true;
		}

		if (jump + 1 > 0 && map.containsKey(jump + 1 + val)) {
			if (canCross(jump + 1, jump + 1 + val, map))
				return true;
		}
		return false;
	}

}
