package May2021GoogLeetcode;

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
		for (int i = 0; i < hand.length; i++) {
			map.compute(hand[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < groupSize; i++) {
			if (map.size() == 0)
				return false;
			int start = map.firstKey();

			for (int j = 0; j < groupSize; j++) {
				if (!map.containsKey(start)) {
					return false;
				}
				map.put(start, map.get(start) - 1);
				if (map.get(start) == 0)
					map.remove(start);

				start += 1;
			}
		}
		return true;
	}
}
