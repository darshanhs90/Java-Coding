package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0739DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		int[] output = new int[T.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = output.length - 1; i >= 0; i--) {
			if (map.isEmpty()) {
				output[i] = 0;
			} else {
				output[i] = Integer.MAX_VALUE;
				for (int j = T[i] + 1; j <= 100; j++) {
					if (map.containsKey(j)) {
						output[i] = Math.min(output[i], map.get(j) - i);
					}
				}

				if (output[i] == Integer.MAX_VALUE)
					output[i] = 0;

			}
			map.put(T[i], i);
		}
		return output;
	}
}
