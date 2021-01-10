package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1207UniqueNumberOfOccurrences {
	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
		System.out.println(uniqueOccurrences(new int[] { 1, 2 }));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (set.contains(entry.getValue()))
				return false;
			set.add(entry.getValue());
		}
		return true;
	}
}
