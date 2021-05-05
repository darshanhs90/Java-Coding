package May2021PrepLeetcode;

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
		return canPartition(0, sum / 2, nums);
	}

	public static boolean canPartition(int index, int reqSum, int[] nums) {
		if (reqSum == 0)
			return true;
		else if (reqSum < 0)
			return false;

		for (int i = index; i < nums.length; i++) {
			if (canPartition(i + 1, reqSum - nums[i], nums))
				return true;
		}
		return false;
	}

}
