package May2021Leetcode;

public class _0416PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { -2, -1, 1, 2 }));
	}

	public static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}
		if (totalSum % 2 != 0)
			return false;

		return canSplit(0, nums, totalSum / 2);
	}

	public static boolean canSplit(int index, int[] nums, int targetSum) {
		if (index >= nums.length || targetSum < 0)
			return false;
		if (targetSum == 0)
			return true;

		for (int i = index; i < nums.length; i++) {
			if (canSplit(i + 1, nums, targetSum - nums[i]))
				return true;
		}
		return false;
	}

}
