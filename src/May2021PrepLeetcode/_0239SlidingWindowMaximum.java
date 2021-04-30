package May2021PrepLeetcode;

import java.util.Arrays;

public class _0239SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, -1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 4, -2 }, 2)));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];

		for (int i = 0; i < nums.length;) {
			int start = i;
			int end = i + k < nums.length ? i + k - 1 : nums.length - 1;

			leftMax[start] = nums[start];
			for (int j = start + 1; j <= end; j++) {
				leftMax[j] = Math.max(leftMax[j - 1], nums[j]);
			}

			i += k;
		}

		for (int i = 0; i < nums.length;) {
			int start = i;
			int end = i + k < nums.length ? i + k - 1 : nums.length - 1;

			rightMax[end] = nums[end];
			for (int j = end - 1; j >= start; j--) {
				rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
			}

			i += k;
		}

		int[] output = new int[nums.length - k + 1];
		for (int i = 0; i < output.length; i++) {
			output[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
		}
		return output;
	}

}
