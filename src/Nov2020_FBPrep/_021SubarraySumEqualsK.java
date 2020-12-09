package Nov2020_FBPrep;

import java.util.HashMap;

public class _021SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
		System.out.println(subarraySum(new int[] { 1 }, 0));
	}

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int currSum = 0;
		map.put(currSum, 1);
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (map.containsKey(currSum - k)) {
				count += map.get(currSum - k);
			}
			map.compute(currSum, (key, v) -> v == null ? 1 : v + 1);
		}
		return count;
	}

}
