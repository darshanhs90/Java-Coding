package Mar2021Leetcode;

import java.util.Arrays;

public class _0238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];

		leftMax[0] = 1;
		rightMax[nums.length - 1] = 1;

		for (int i = 1; i < leftMax.length; i++) {
			leftMax[i] = leftMax[i - 1] * nums[i - 1];
		}

		for (int i = rightMax.length - 2; i >= 0; i--) {
			rightMax[i] = rightMax[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = leftMax[i] * rightMax[i];
		}
		return nums;
	}

}
