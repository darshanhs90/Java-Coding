package Feb2021Leetcode;

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
			int leftLimit = i;
			int rightLimit = i + k - 1 < nums.length ? i + k - 1 : nums.length - 1;

			leftMax[leftLimit] = nums[leftLimit];
			for (int j = leftLimit + 1; j <= rightLimit; j++) {
				leftMax[j] = Math.max(leftMax[j - 1], nums[j]);
			}

			rightMax[rightLimit] = nums[rightLimit];

			for (int j = rightLimit - 1; j >= leftLimit; j--) {
				rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
			}

			i += k;
		}

		int[] out = new int[nums.length - k + 1];
		for (int i = 0; i < out.length; i++) {
			out[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
		}
		return out;
	}

}
