package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _0239SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, -1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 4, -2 }, 2)));

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = nums[0];
		right[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1; i < nums.length; i++) {
			// from left to right
			if (i % k == 0)
				left[i] = nums[i]; // block_start
			else
				left[i] = Math.max(left[i - 1], nums[i]);

			// from right to left
			int j = nums.length - i - 1;
			if ((j + 1) % k == 0)
				right[j] = nums[j]; // block_end
			else
				right[j] = Math.max(right[j + 1], nums[j]);
		}

		int[] output = new int[nums.length - k + 1];
		for (int i = 0; i < output.length; i++) {
			output[i] = (Math.max(left[i + k - 1], right[i]));
		}
		return output;
	}

	public static int[] maxSlidingWindow1(int[] nums, int k) {
		List<Integer> output = new ArrayList<Integer>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			q.offer(nums[i]);
			if (q.size() == k) {
				output.add(q.peek());
				q.remove(nums[i + 1 - k]);
			}
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < output.size(); i++) {
			out[i] = output.get(i);
		}
		return out;
	}

}
