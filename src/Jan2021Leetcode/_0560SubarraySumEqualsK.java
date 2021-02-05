package Jan2021Leetcode;

import java.util.HashMap;

public class _0560SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum1(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum1(new int[] { 1, 2, 3 }, 3));
	}

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - k))
				count += map.get(sum - k);

			map.compute(sum, (key, v) -> v == null ? 1 : v + 1);
		}
		return count;
	}

	public static int subarraySum1(int[] nums, int k) {
		int count = 0;
		int[] sumArr = new int[nums.length + 1];
		sumArr[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sumArr[i + 1] = sumArr[i] + nums[i];
		}

		for (int i = 0; i < sumArr.length; i++) {
			for (int j = i + 1; j < sumArr.length; j++) {
				if (sumArr[j] - sumArr[i] == k)
					count++;
			}
		}

		return count;
	}
}
