package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0697DegreeOfAnArray {

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
		System.out.println(findShortestSubArray(new int[] { 1, 2, 2, 3, 3, 3, 2 }));
		System.out.println(findShortestSubArray(new int[] { 2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2 }));
	}

	public static int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> startIndex = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> endIndex = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		List<Integer> maxCountElements = new ArrayList<Integer>();
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			counts.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
			if (counts.get(nums[i]) > max) {
				max = counts.get(nums[i]);
				maxCountElements.clear();
				maxCountElements.add(nums[i]);
			} else if (counts.get(nums[i]) == max) {
				maxCountElements.add(nums[i]);
			}

			if (endIndex.containsKey(nums[i])) {
				endIndex.put(nums[i], i);
			} else {
				startIndex.put(nums[i], i);
				endIndex.put(nums[i], i);
			}
		}
		int minLen = Integer.MAX_VALUE;
		for (Integer num : maxCountElements) {
			minLen = Math.min(endIndex.get(num) - startIndex.get(num) + 1, minLen);
		}
		return minLen;
	}
}
