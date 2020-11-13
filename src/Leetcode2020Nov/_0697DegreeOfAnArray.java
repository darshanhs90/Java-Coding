package Leetcode2020Nov;

import java.util.HashMap;
import java.util.Map;

public class _0697DegreeOfAnArray {

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 3, 3, 2 }));
	}

	public static int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> elementStartMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> elementLengthMap = new HashMap<Integer, Integer>();
		elementCountMap.put(nums[0], 1);
		elementStartMap.put(nums[0], 0);
		elementLengthMap.put(nums[0], 1);
		int maxCount = 1;
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (elementCountMap.containsKey(num)) {
				elementCountMap.computeIfPresent(num, (k, v) -> v + 1);
				elementLengthMap.put(num, i - elementStartMap.get(num) + 1);
				maxCount = Math.max(maxCount, elementCountMap.get(num));
			} else {
				elementCountMap.put(num, 1);
				elementStartMap.put(num, i);
				elementLengthMap.put(num, 1);
			}
		}

		int minLength = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
			if (entry.getValue() == maxCount) {
				minLength = Math.min(minLength, elementLengthMap.get(entry.getKey()));
			}
		}
		return minLength;
	}
}
