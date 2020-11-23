package Nov2020Leetcode;

import java.util.Arrays;

public class _0506RelativeRanks {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRelativeRanks(new int[] { 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(findRelativeRanks(new int[] { 1, 2, 5, 4, 3 })));
	}

	public static String[] findRelativeRanks(int[] nums) {
		int[] newNums = nums.clone();
		Arrays.sort(nums);
		String[] output = new String[nums.length];
		for (int i = 0; i < output.length; i++) {
			int index = findIndex(nums, newNums[i]);
			if (index == nums.length - 1) {
				output[i] = "Gold Medal";
			} else if (index == nums.length - 2) {
				output[i] = "Silver Medal";
			} else if (index == nums.length - 3) {
				output[i] = "Bronze Medal";
			} else {
				output[i] = nums.length - index + "";
			}
		}
		return output;
	}

	public static int findIndex(int[] nums, int val) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val)
				return i;
		}
		return -1;
	}
}
