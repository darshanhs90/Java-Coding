package Jan2021Leetcode;

import java.util.Arrays;

public class _0238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length < 2)
			return nums;
		int left[] = new int[nums.length];
		int right[] = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < right.length; i++) {
			left[i] = nums[i - 1] * left[i - 1];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = nums[i + 1] * right[i + 1];
		}

		for (int i = 0; i < right.length; i++) {
			nums[i] = left[i] * right[i];
		}

		return nums;
	}

}
