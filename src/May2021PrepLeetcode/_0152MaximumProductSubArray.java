package May2021PrepLeetcode;

public class _0152MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = nums[0];
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
			min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));
			res = Math.max(max, res);
		}
		return res;
	}
}
