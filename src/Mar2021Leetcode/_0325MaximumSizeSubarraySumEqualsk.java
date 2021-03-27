package Mar2021Leetcode;

import java.util.HashMap;

public class _0325MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		System.out.println(maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 3));
		System.out.println(maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));
	}

	public static int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				maxSum = Math.max(maxSum, i - map.get(sum - k));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxSum;
	}

}
