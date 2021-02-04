package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0739DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0)
			return T;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(T[T.length - 1], T.length - 1);
		T[T.length - 1] = 0;
		for (int i = T.length - 2; i >= 0; i--) {
			int val = T[i];
			int minDistance = Integer.MAX_VALUE;
			for (int j = val + 1; j <= 100; j++) {
				if (map.containsKey(j)) {
					minDistance = Math.min(minDistance, map.get(j) - i);
				}
			}

			map.put(T[i], i);
			if (minDistance == Integer.MAX_VALUE)
				T[i] = 0;
			else
				T[i] = minDistance;
		}
		return T;
	}
}
