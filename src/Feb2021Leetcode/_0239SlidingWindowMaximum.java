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
			leftMax[i] = nums[i];
			int limit = i + k - 1;
			i++;
			while (i <= limit && i < nums.length) {
				leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
				i++;
			}
		}

		for (int i = 0; i < nums.length;) {
			int leftLimit = i;
			int rightLimit = i + k - 1 < nums.length ? i + k - 1 : nums.length - 1;

			rightMax[rightLimit] = nums[rightLimit];
			rightLimit--;
			while (rightLimit >= leftLimit) {
				rightMax[rightLimit] = Math.max(rightMax[rightLimit + 1], nums[rightLimit]);
				rightLimit--;
			}
			i += k;
		}

		int[] output = new int[nums.length - k + 1];

		for (int i = 0; i < nums.length - k + 1;i++) {
			output[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
		}
		return output;
	}

}
