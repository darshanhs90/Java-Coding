package June2021GoogLeetcode;

import java.util.HashMap;

public class _0659SplitArrayIntoConsecutiveSubsequences {

	public static void main(String[] args) {
		System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));
		System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));
		System.out.println(isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
	}

	public static boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> availMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> reqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			availMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int num : nums) {
			if (availMap.get(num) == 0)
				continue;

			if (reqMap.containsKey(num) && reqMap.get(num) > 0) {
				reqMap.put(num, reqMap.get(num) - 1);
				reqMap.compute(num + 1, (k, v) -> v == null ? 1 : v + 1);
				availMap.put(num, availMap.get(num) - 1);
			} else if (availMap.getOrDefault(num, 0) > 0 && availMap.getOrDefault(num + 1, 0) > 0
					&& availMap.getOrDefault(num + 2, 0) > 0) {
				availMap.put(num, availMap.get(num) - 1);
				availMap.put(num + 1, availMap.get(num + 1) - 1);
				availMap.put(num + 2, availMap.get(num + 2) - 1);
				reqMap.compute(num + 3, (k, v) -> v == null ? 1 : v + 1);
			} else {
				return false;
			}

		}
		return true;
	}

}
