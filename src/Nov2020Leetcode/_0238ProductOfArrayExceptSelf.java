package Nov2020Leetcode;

import java.util.Arrays;

public class _0238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));

	}

	public static int[] productExceptSelf(int[] nums) {
		int[] result1 = new int[nums.length];
		result1[0] = 1;
		for (int i = 1; i < result1.length; i++) {
			result1[i] = result1[i - 1] * nums[i - 1];
		}
		int[] result2 = new int[nums.length];
		result2[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result2[i] = result2[i + 1] * nums[i + 1];
		}

		int[] output = new int[nums.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = result1[i] * result2[i];
		}

		return output;
	}

}
