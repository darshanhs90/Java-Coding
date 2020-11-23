package Nov2020Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1207UniqueNumberOfOccurrences {
	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
		System.out.println(uniqueOccurrences(new int[] { 1, 2 }));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		if (arr == null || arr.length < 2)
			return true;
		HashMap<Integer, Integer> elementsMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int prevCount = 0;
			if (elementsMap.containsKey(arr[i])) {
				prevCount = elementsMap.get(arr[i]);
				elementsMap.put(arr[i], prevCount + 1);
			} else {
				prevCount = 0;
				elementsMap.put(arr[i], 1);
			}

			if (prevCount != 0) {
				if (countMap.containsKey(prevCount)) {
					countMap.computeIfPresent(prevCount, (k, v) -> v - 1);
					countMap.compute(prevCount + 1, (k, v) -> v == null ? 1 : v + 1);

				} else {
					countMap.compute(prevCount + 1, (k, v) -> v == null ? 1 : v + 1);
				}
			} else {
				countMap.compute(1, (k, v) -> v == null ? 1 : v + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1) {
				return false;
			}
		}
		return true;
	}
}
