package Nov2020_FBPrep;

import java.util.Arrays;

public class _016ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int[] res1 = new int[nums.length];
		int[] res2 = new int[nums.length];
		res1[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res1[i] = res1[i - 1] * nums[i - 1];
		}

		res2[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			res2[i] = res2[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = res1[i] * res2[i];
		}
		return nums;
	}
}
