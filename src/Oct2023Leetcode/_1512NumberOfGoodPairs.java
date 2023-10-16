package Oct2023Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1512NumberOfGoodPairs {
	public static void main(String[] args) {
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

	public static int numIdenticalPairs(int[] nums) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			count += (val * (val - 1) / 2);
		}
		return count;
	}
}
