package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _1200MinimumAbsoluteDifference {
	public static void main(String[] args) {
		System.out.println(minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
		System.out.println(minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 }));
		System.out.println(minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		Arrays.parallelSort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - arr[i - 1]);
			minDiff = Math.min(minDiff, diff);
			if (map.containsKey(diff)) {
				List<List<Integer>> list = map.get(diff);
				List<Integer> newList = new ArrayList<Integer>();
				newList.add(arr[i - 1]);
				newList.add(arr[i]);
				list.add(newList);
				map.put(diff, list);
			} else {
				List<List<Integer>> list = new ArrayList<List<Integer>>();
				List<Integer> newList = new ArrayList<Integer>();
				newList.add(arr[i - 1]);
				newList.add(arr[i]);
				list.add(newList);
				map.put(diff, list);
			}
		}
		return map.get(minDiff);
	}

}
