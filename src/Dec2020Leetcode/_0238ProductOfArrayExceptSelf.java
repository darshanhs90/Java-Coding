package Dec2020Leetcode;

import java.util.Arrays;

public class _0238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] forward = new int[nums.length];
		int[] backward = new int[nums.length];
		forward[0] = 1;
		backward[backward.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			forward[i] = forward[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			backward[i] = backward[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = forward[i] * backward[i];
		}
		return nums;
	}

}
