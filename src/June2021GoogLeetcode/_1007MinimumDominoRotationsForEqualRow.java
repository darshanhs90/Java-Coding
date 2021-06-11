package June2021GoogLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _1007MinimumDominoRotationsForEqualRow {
	public static void main(String[] args) {
		System.out.println(minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
		System.out.println(minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 }));
	}

	public static int minDominoRotations(int[] tops, int[] bottoms) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> sameMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < bottoms.length; i++) {
			if (tops[i] == bottoms[i]) {
				sameMap.compute(tops[i], (k, v) -> v == null ? 1 : v + 1);
			}
			map1.compute(tops[i], (k, v) -> v == null ? 1 : v + 1);
			map2.compute(bottoms[i], (k, v) -> v == null ? 1 : v + 1);
		}

		int minChange = Integer.MAX_VALUE;
		int n = tops.length;
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			int map1Val = entry.getValue().intValue();
			int map2Val = map2.getOrDefault(entry.getKey(), 0);
			int sameVal = sameMap.getOrDefault(entry.getKey(), 0);

			if (map1Val + map2Val - sameVal == n) {
				minChange = Math.min(minChange, Math.min(map1Val, map2Val) - sameVal);
			}
		}
		return minChange == Integer.MAX_VALUE ? -1 : minChange;
	}
}
