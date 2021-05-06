package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _1213IntersectionOfThreeSortedArrays {
	public static void main(String[] args) {
		System.out.println(arraysIntersection(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 5, 7, 9 },
				new int[] { 1, 3, 4, 5, 8 }));
		System.out.println(arraysIntersection(new int[] { 197, 418, 523, 876, 1356 },
				new int[] { 501, 880, 1593, 1710, 1870 }, new int[] { 521, 682, 1337, 1395, 1764 }));
	}

	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < arr1.length; i++) {
			map.compute(arr1[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i]))
				continue;
			map.compute(arr2[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < arr3.length; i++) {
			if (!map.containsKey(arr3[i]))
				continue;
			map.compute(arr3[i], (k, v) -> v == null ? 1 : v + 1);
		}

		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 3)
				list.add(entry.getKey());
		}
		return list;
	}
}
