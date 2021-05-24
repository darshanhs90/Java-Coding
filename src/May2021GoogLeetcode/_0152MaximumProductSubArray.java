package May2021GoogLeetcode;

public class _0152MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		long max = nums[0];
		long min = nums[0];
		long res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			long temp = max;
			max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
			min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
			res = Math.max(res, max);
		}
		return (int) res;
	}
}
