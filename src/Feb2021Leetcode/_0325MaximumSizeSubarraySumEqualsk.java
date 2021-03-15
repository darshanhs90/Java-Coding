package Feb2021Leetcode;

import java.util.HashMap;

public class _0325MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		System.out.println(maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 3));
		System.out.println(maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));
	}

	public static int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSum = 0;
		map.put(currSum, -1);
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (map.containsKey(currSum - k)) {
				maxLength = Math.max(maxLength, i - map.get(currSum - k));
			}

			if (!map.containsKey(currSum)) {
				map.put(currSum, i);
			}
		}
		return maxLength;
	}

}
