package April2021Leetcode;

public class _0416PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { -2, -1, 1, 2 }));
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		return canPartition(0, nums, 0, sum / 2);
	}

	public static boolean canPartition(int index, int[] nums, int currSum, int requiredSum) {
		if (currSum == requiredSum)
			return true;
		if (index >= nums.length)
			return false;
		for (int i = index; i < nums.length; i++) {
			if (canPartition(i + 1, nums, currSum + nums[i], requiredSum))
				return true;
		}
		return false;
	}

}
