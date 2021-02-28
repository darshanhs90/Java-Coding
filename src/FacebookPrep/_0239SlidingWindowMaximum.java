package FacebookPrep;

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

		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];

		for (int i = 0; i < nums.length;) {
			int rightIndex = i + k - 1 < nums.length ? i + k - 1 : nums.length - 1;

			leftMax[i] = nums[i];
			i++;
			while (i <= rightIndex) {
				leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
				i++;
			}
		}

		for (int i = 0; i < nums.length;) {
			int leftIndex = i;
			int rightIndex = i + k - 1 < nums.length ? i + k - 1 : nums.length - 1;

			rightMax[rightIndex] = nums[rightIndex];
			int index = rightIndex - 1;
			while (index >= leftIndex) {
				rightMax[index] = Math.max(rightMax[index + 1], nums[index]);
				index--;
			}
			i += k;
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < rightMax.length - k + 1; i++) {
			list.add(Math.max(rightMax[i], leftMax[i + k - 1]));
		}
		int[] out = new int[list.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = list.get(i);
		}
		return out;
	}

}
