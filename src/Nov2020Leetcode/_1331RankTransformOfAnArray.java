package Nov2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _1331RankTransformOfAnArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 40, 10, 20, 30 })));
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 100, 100, 100 })));
		System.out.println(Arrays.toString(arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 })));
	}

	public static int[] arrayRankTransform(int[] arr) {
		int[] newArray = arr.clone();
		Arrays.sort(arr);
		int count = 1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], count);
				count++;
			}
		}

		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = map.get(newArray[i]);
		}
		return newArray;
	}
}
