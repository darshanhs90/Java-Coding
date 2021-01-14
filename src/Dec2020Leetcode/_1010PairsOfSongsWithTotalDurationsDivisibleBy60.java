package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		Set<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();

			if (!visited.contains(key)) {
				if (key == 0 || key == 30) {
					count += value * (value - 1) / 2;
				} else {
					if (map.containsKey(60 - key)) {
						count += value * map.get(60 - key);
					}
				}
			}
			visited.add(key);
			visited.add(60 - key);
		}
		return count;
	}
}
