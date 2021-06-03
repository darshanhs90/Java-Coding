package May2021GoogLeetcode;

import java.util.HashMap;

public class _0659SplitArrayIntoConsecutiveSubsequences {

	public static void main(String[] args) {
		System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));
		System.out.println(isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));
		System.out.println(isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
	}

	public static boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> reqMap = new HashMap<Integer, Integer>();
		for (int num : nums) {
			numMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
		}

		for (int num : nums) {
			if (numMap.get(num) == 0)
				continue;

			else if (reqMap.containsKey(num) && reqMap.get(num) > 0) {
				numMap.put(num, numMap.get(num) - 1);
				reqMap.put(num, reqMap.get(num) - 1);
				reqMap.compute(num + 1, (k, v) -> v == null ? 1 : v + 1);
			} else if (numMap.getOrDefault(num, 0) > 0 && numMap.getOrDefault(num + 1, 0) > 0
					&& numMap.getOrDefault(num + 2, 0) > 0) {
				numMap.put(num, numMap.get(num) - 1);
				numMap.put(num + 1, numMap.get(num + 1) - 1);
				numMap.put(num + 2, numMap.get(num + 2) - 1);

				reqMap.compute(num + 3, (k, v) -> v == null ? 1 : v + 1);
			} else {
				return false;
			}
		}
		return true;
	}

}
