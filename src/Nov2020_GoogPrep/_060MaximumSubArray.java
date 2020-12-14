package Nov2020_GoogPrep;

public class _060MaximumSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { 1 }));
		System.out.println(maxSubArray(new int[] { 0 }));
		System.out.println(maxSubArray(new int[] { -1 }));
		System.out.println(maxSubArray(new int[] { -2147483647 }));
	}

	static long maxSum = Long.MIN_VALUE;

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		maxSum = Long.MIN_VALUE;
		maxSum = Math.max(maxSum, nums[0]);
		int currSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (currSum + nums[i] > nums[i]) {
				currSum = currSum + nums[i];
			} else {
				currSum = nums[i];
			}
			maxSum = Math.max(maxSum, currSum);
		}
		return (int) maxSum;
	}
}
