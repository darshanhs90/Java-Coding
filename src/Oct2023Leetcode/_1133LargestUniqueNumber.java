package Oct2023Leetcode;

import java.util.HashMap;

public class _1133LargestUniqueNumber {
	public static void main(String[] args) {
		System.out.println(largestUniqueNumber(new int[] { 5, 7, 3, 9, 4, 9, 8, 3, 1 }));// 8
		System.out.println(largestUniqueNumber(new int[] { 9, 9, 8, 8 }));// -1
	}

	public static int largestUniqueNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxNum = -1;
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == 1) {
				maxNum = Math.max(maxNum, nums[i]);
			}
		}
		return maxNum;
	}
}
