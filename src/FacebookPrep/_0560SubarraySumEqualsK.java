package FacebookPrep;

import java.util.HashMap;

public class _0560SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
	}

	public static int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int sum = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
