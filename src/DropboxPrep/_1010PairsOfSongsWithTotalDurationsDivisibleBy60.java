package DropboxPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static void main(String[] args) {
		System.out.println(numPairsDivisibleBy60(new int[] { 30, 20, 150, 100, 40 }));
		System.out.println(numPairsDivisibleBy60(new int[] { 60, 60, 60 }));
	}

	public static int numPairsDivisibleBy60(int[] time) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < time.length; i++) {
			int songTime = time[i] % 60;
			map.compute(songTime, (k, v) -> v == null ? 1 : v + 1);
		}

		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (!set.contains(entry.getKey())) {
				int timeVal = entry.getKey();
				int timeValCount = entry.getValue();
				if (timeVal == 0 || timeVal == 30) {
					count += (timeValCount) * (timeValCount - 1) / 2;
				} else {
					if (map.containsKey(60 - timeVal)) {
						count += timeValCount * map.get(60 - timeVal);
					}
					set.add(timeVal);
					set.add(60 - timeVal);
				}
			}
		}
		return count;
	}
}
