package Feb2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0739DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] output = new int[T.length];

		for (int i = T.length - 1; i >= 0; i--) {
			map.put(T[i], i);
			int diff = Integer.MAX_VALUE;
			for (int j = T[i] + 1; j <= 100; j++) {
				if (map.containsKey(j)) {
					if (map.get(j) - i < diff) {
						diff = map.get(j) - i;
					}

				}
			}
			output[i] = diff == Integer.MAX_VALUE ? 0 : diff;
		}
		return output;
	}
}
