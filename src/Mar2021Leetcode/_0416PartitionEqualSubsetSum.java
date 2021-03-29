package Mar2021Leetcode;

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

		return canPartition(0, null, nums, totalSum / 2);
	}

	public static boolean canPartition(int index, Integer currSum, int[] nums, int requiredSum) {
		if (currSum != null) {
			if (currSum == requiredSum)
				return true;
			if (currSum > requiredSum)
				return false;
		}
		currSum = currSum == null ? 0 : currSum;
		boolean canPartition = false;
		for (int i = index; i < nums.length; i++) {
			canPartition = canPartition || canPartition(i + 1, currSum + nums[i], nums, requiredSum);
		}
		return canPartition;
	}

}
