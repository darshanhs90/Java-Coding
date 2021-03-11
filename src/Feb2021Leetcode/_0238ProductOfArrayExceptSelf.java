package Feb2021Leetcode;

import java.util.Arrays;

public class _0238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] leftSum = new int[nums.length];
		int[] rightSum = new int[nums.length];

		leftSum[0] = 1;
		rightSum[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			leftSum[i] = leftSum[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rightSum[i] = rightSum[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < rightSum.length; i++) {
			nums[i] = leftSum[i] * rightSum[i];
		}
		return nums;
	}

}
