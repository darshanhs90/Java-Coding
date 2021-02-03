package Jan2021Leetcode;

public class _0152MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int maxProd = nums[0];
		int minProd = nums[0];
		int maxOut = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int currMax = maxProd;
			maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
			minProd = Math.min(nums[i], Math.min(currMax * nums[i], minProd * nums[i]));
			maxOut = Math.max(maxOut, maxProd);
		}

		return maxOut;
	}
}
