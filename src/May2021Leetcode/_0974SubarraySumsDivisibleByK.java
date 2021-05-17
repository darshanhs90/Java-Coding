package May2021Leetcode;

import java.util.HashMap;

public class _0974SubarraySumsDivisibleByK {
	public static void main(String[] args) {
		System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
	}

	public static int subarraysDivByK(int[] nums, int K) {
		int count = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sum = sum % K;
			if (sum < 0)
				sum += K;

			if (map.containsKey(sum)) {
				count += map.get(sum);
			}

			map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
		}
		return count;
	}
}
