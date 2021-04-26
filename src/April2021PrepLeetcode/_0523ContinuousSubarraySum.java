package April2021PrepLeetcode;

import java.util.HashMap;

public class _0523ContinuousSubarraySum {

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 13));
		System.out.println(checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
		System.out.println(checkSubarraySum(new int[] { 1, 1, 1, 1, 2, 1, 5 }, 6));
		System.out.println(checkSubarraySum(new int[] { 0, 0 }, 0));
		System.out.println(checkSubarraySum(new int[] { 1, 2, 3 }, 5));
	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0)
				sum = sum % k;

			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1)
					return true;
			}

			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return false;
	}
}
