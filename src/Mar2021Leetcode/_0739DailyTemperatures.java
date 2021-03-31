package Mar2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0739DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = T.length - 1; i >= 0; i--) {
			if (map.isEmpty()) {
				map.put(T[i], i);
				T[i] = 0;
			} else {
				int minDiff = Integer.MAX_VALUE;
				for (int j = 100; j >= 30; j--) {
					if (j > T[i]) {
						if (map.containsKey(j)) {
							minDiff = Math.min(minDiff, map.get(j) - i);
						}
					} else {
						break;
					}
				}
				map.put(T[i], i);
				T[i] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
			}
		}
		return T;
	}
}
