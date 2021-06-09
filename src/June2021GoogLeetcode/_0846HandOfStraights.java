package June2021GoogLeetcode;

import java.util.Map;
import java.util.TreeMap;

public class _0846HandOfStraights {
	public static void main(String[] args) {
		System.out.println(isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
		System.out.println(isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4));
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int val : hand) {
			map.compute(val, (k, v) -> v == null ? 1 : v + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				int key = entry.getKey();
				int value = entry.getValue();
				while (value > 0) {
					for (int i = 0; i < groupSize; i++) {
						int newKey = key + i;
						if (map.containsKey(newKey) && map.get(newKey) > 0) {
							map.put(newKey, map.get(newKey) - 1);
						} else {
							return false;
						}
					}
					value--;
				}
			}
		}
		return true;
	}
}
