package April2021PrepLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		System.out.println(numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));
		System.out.println(numPairsDivisibleBy60(new int[] { 60, 60, 60 }));
	}

	public static int numPairsDivisibleBy60(int[] time) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < time.length; i++) {
			map.compute(time[i] % 60, (k, v) -> v == null ? 1 : v + 1);
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (key == 0 || key == 30) {
				count += (value * (value - 1) / 2);
			} else {
				if (map.containsKey(60 - key)) {
					count += value * map.get(60 - key);
					map.put(60 - key, 0);
				}
			}
		}
		return count;
	}
}
