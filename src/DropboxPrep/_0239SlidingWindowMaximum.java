package DropboxPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0239SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, -1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 4, -2 }, 2)));

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int leftMax[] = new int[nums.length];
		int rightMax[] = new int[nums.length];
		for (int i = 0; i < nums.length;) {
			int max = nums[i];
			leftMax[i] = max;
			int limit = i + k;
			i++;
			while (i < nums.length && i < limit) {
				max = Math.max(max, nums[i]);
				leftMax[i] = max;
				i++;
			}
		}

		for (int i = 0; i < nums.length;) {
			int limit = i;
			int rightIndex = i + k - 1 < nums.length ? i + k - 1 : nums.length - 1;

			int currVal = nums[rightIndex];
			rightMax[rightIndex] = currVal;
			rightIndex--;
			while (rightIndex >= limit) {
				rightMax[rightIndex] = Math.max(rightMax[rightIndex + 1], nums[rightIndex]);
				rightIndex--;
			}
			i += k;
		}

		System.out.println(Arrays.toString(leftMax));
		System.out.println(Arrays.toString(rightMax));

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - k + 1; i++) {
			list.add(Math.max(rightMax[i], leftMax[i + k - 1]));
		}

		int[] out = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			out[i] = list.get(i);
		}

		return out;
	}

}
