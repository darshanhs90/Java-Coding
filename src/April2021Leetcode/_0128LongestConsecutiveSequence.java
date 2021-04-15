package April2021Leetcode;

import java.util.HashSet;

public class _0128LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int num = nums[i];
				int currLength = 0;
				while (set.contains(num)) {
					currLength += 1;
					num += 1;
				}

				maxLength = Math.max(maxLength, currLength);
			}
		}
		return maxLength;
	}
}
