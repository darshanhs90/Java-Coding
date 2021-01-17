package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0532KdiffPairsInAnArray {

	public static void main(String[] args) {
		System.out.println(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));
		System.out.println(findPairs(new int[] { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 }, 3));
		System.out.println(findPairs(new int[] { -1, -2, -3 }, 1));
	}

	public static int findPairs(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, v) -> v == null ? 1 : v + 1);
		}

		int count = 0;
		if (k == 0) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int val = entry.getValue();
				if (val > 1)
					count += 1;
			}
		} else {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

				int kDiff = entry.getKey() - k;
				if (map.containsKey(kDiff)) {
					count += 1;
				}
			}
		}
		return count;
	}

}
