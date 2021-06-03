package May2021GoogLeetcode;

import java.util.Arrays;

public class _0416PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { -2, -1, 1, 2 }));
	}

	public static boolean canPartition(int[] nums) {
		Arrays.sort(nums);
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}

		if (total % 2 != 0)
			return false;
		return helper(0, nums, total / 2);
	}

	public static boolean helper(int index, int[] nums, int reqdSum) {
		if (reqdSum == 0)
			return true;
		if (index >= nums.length || reqdSum < 0)
			return false;

		for (int i = index; i < nums.length; i++) {
			if (helper(i + 1, nums, reqdSum - nums[i]))
				return true;
		}
		return false;
	}

}
