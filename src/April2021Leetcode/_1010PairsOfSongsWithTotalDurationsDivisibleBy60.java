package April2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		System.out.println(numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));
		System.out.println(numPairsDivisibleBy60(new int[] { 60, 60, 60 }));
	}

	public static int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < time.length; i++) {
			map.compute(time[i] % 60, (k, v) -> v == null ? 1 : v + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == 0 || entry.getKey() == 30) {
				if (entry.getValue() > 0)
					count += ((entry.getValue() * (entry.getValue() - 1)) / 2);
			} else {
				if (map.containsKey(60 - entry.getKey())) {
					count += entry.getValue() * map.get(60 - entry.getKey());
					map.put(60 - entry.getKey(), 0);
				}
			}
		}
		return count;
	}
}
