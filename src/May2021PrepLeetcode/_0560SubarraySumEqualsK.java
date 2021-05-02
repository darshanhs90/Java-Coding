package May2021PrepLeetcode;

import java.util.HashMap;

public class _0560SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
	}

	public static int subarraySum(int[] nums, int k) {
		int currSum = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(currSum, 1);
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (map.containsKey(currSum - k)) {
				count += map.get(currSum - k);
			}

			map.compute(currSum, (key, val) -> val == null ? 1 : val + 1);
		}
		return count;
	}
}
