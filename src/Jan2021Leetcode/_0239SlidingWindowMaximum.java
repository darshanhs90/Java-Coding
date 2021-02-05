package Jan2021Leetcode;

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
		List<Integer> output = new ArrayList<Integer>();
		int leftMax[] = new int[nums.length];
		int rightMax[] = new int[nums.length];

		for (int i = 0; i < rightMax.length;) {
			int count = 1;
			leftMax[i] = nums[i];
			i++;
			while (i < nums.length && count < k) {
				leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
				i++;
				count++;
			}
		}

		for (int i = 0; i < rightMax.length;) {
			int leftBound = i;
			int rightBound = i + k - 1 < rightMax.length ? i + k - 1 : rightMax.length - 1;
			rightMax[rightBound] = nums[rightBound];
			for (int j = rightBound - 1; j >= leftBound; j--) {
				rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
			}
			i += k;
		}

		for (int i = 0; i <= nums.length - k; i++) {
			output.add(Math.max(leftMax[i + k - 1], rightMax[i]));
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

	public static int[] maxSlidingWindow1(int[] nums, int k) {
		List<Integer> output = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());

		int left = 0, right = 0;
		while (right < nums.length) {
			if (pq.size() < k) {
				pq.offer(nums[right]);
			}

			if (pq.size() == k) {
				output.add(pq.peek());
				pq.remove(nums[left]);
				left++;
			}

			right++;
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

}
