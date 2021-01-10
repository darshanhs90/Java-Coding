package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200MinimumAbsoluteDifference {
	public static void main(String[] args) {
		System.out.println(minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
		System.out.println(minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 }));
		System.out.println(minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			minDiff = Math.min(minDiff, -arr[i] + arr[i + 1]);
		}

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == minDiff) {
				output.add(new ArrayList<Integer>(Arrays.asList(arr[i], arr[i + 1])));
			}
		}
		return output;
	}
}
