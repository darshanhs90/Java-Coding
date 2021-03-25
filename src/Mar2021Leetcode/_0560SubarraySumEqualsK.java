package Mar2021Leetcode;

import java.util.HashMap;

public class _0560SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
	}

	public static int subarraySum(int[] nums, int k) {
		if (nums == null)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
		}
		return count;
	}
}
