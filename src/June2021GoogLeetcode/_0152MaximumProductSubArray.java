package June2021GoogLeetcode;

public class _0152MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		long maxSoFar = nums[0];
		long minSoFar = nums[0];
		long res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			long tempMax = maxSoFar;
			maxSoFar = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
			minSoFar = Math.min(nums[i], Math.min(tempMax * nums[i], minSoFar * nums[i]));
			res = Math.max(res, maxSoFar);
		}
		return (int) res;
	}
}
