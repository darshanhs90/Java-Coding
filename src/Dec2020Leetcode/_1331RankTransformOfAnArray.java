package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _1331RankTransformOfAnArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 40, 10, 20, 30 })));
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 100, 100, 100 })));
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 })));
	}

	public static int[] arrayRankTransform(int[] arr) {

		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		int rank = 1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < sorted.length; i++) {
			if (!map.containsKey(sorted[i])) {
				map.put(sorted[i], rank);
				rank++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(arr[i]);
		}
		return arr;
	}
}
