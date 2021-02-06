package Jan2021Leetcode;

import java.util.Map;
import java.util.TreeMap;

public class _0532KdiffPairsInAnArray {

	public static void main(String[] args) {
		System.out.println(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));
		System.out.println(findPairs(new int[] { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 }, 3));
		System.out.println(findPairs(new int[] { -1, -2, -3 }, 1));
	}

	public static int findPairs(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, val) -> val == null ? 1 : val + 1);
		}

		int noOfPairs = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getKey() + k == entry.getKey() && entry.getValue() > 1) {
				noOfPairs++;
			} else if (entry.getKey() + k != entry.getKey() && map.containsKey(entry.getKey() + k))
				noOfPairs++;
		}
		return noOfPairs;
	}

}
