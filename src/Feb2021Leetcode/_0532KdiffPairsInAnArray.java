package Feb2021Leetcode;

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
		if (nums == null || nums.length < 2)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (kev, val) -> val == null ? 1 : val + 1);
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (map.containsKey(entry.getKey() + k) && k != 0 || k == 0 && entry.getValue() > 1)
				count++;
		}
		return count;
	}

}
