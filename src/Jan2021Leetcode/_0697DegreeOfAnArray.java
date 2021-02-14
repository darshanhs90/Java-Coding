package Jan2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0697DegreeOfAnArray {

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 3, 3, 2 }));
		System.out.println(findShortestSubArray(new int[] { 2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2 }));
	}

	public static int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> startMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> endMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		int maxCount = 0;

		for (int i = 0; i < nums.length; i++) {
			countMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
			if (countMap.get(nums[i]) > maxCount) {
				maxCount = countMap.get(nums[i]);
			}

			if (!startMap.containsKey(nums[i])) {
				startMap.put(nums[i], i);
			}

			endMap.put(nums[i], i);
		}

		int minLength = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() == maxCount) {
				minLength = Math.min(minLength, endMap.get(entry.getKey()) - startMap.get(entry.getKey()) + 1);
			}
		}

		return minLength;
	}
}
