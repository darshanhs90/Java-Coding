package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0739DailyTemperatures {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
	}

	public static int[] dailyTemperatures(int[] T) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = T.length - 1; i >= 0; i--) {
			int out = T[i];
			if (map.isEmpty()) {
				T[i] = 0;
			} else {
				int minDays = Integer.MAX_VALUE;
				for (int j = out + 1; j <= 100; j++) {
					if (map.containsKey(j)) {
						minDays = Math.min(minDays, map.get(j) - i);
					}
				}
				T[i] = minDays == Integer.MAX_VALUE ? 0 : minDays;
			}
			map.put(out, i);
		}
		return T;
	}
}
