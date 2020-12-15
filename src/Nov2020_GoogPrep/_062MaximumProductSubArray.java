package Nov2020_GoogPrep;

public class _062MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int maxSoFar = nums[0];
		int minSoFar = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tempMax = maxSoFar;
			maxSoFar = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * minSoFar));
			minSoFar = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * minSoFar));
			res = Math.max(maxSoFar, res);
		}
		return res;
	}
}
