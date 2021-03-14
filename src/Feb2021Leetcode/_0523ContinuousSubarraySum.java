package Feb2021Leetcode;

import java.util.HashMap;

public class _0523ContinuousSubarraySum {

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
		System.out.println(checkSubarraySum(new int[] { 1, 1, 1, 1, 2, 1, 5 }, 6));
		System.out.println(checkSubarraySum(new int[] { 0, 0 }, 0));
		System.out.println(checkSubarraySum(new int[] { 1, 2, 3 }, 5));
	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (k != 0)
				currSum = currSum % k;

			if (map.containsKey(currSum)) {
				if (i - map.get(currSum) >= 2)
					return true;
			} else {
				map.put(currSum, i);
			}
		}
		return false;
	}
}
