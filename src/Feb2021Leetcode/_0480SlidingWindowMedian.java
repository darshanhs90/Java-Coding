package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0480SlidingWindowMedian {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 2147483647, 2147483647 }, 2)));
	}

	public static double[] medianSlidingWindow(int[] nums, int k) {
		List<Long> output = new ArrayList<Long>();
		double[] out = new double[nums.length - k+1];
		int left = 0, right = 0;
		int index = 0;
		while (right < nums.length) {

			output.add((long)nums[right]);
			if (output.size() == k) {
				Collections.sort(output);
				if (k % 2 == 0) {
					long val = output.get(k / 2 - 1) + output.get(k / 2);
					out[index] = val / (double) 2;
				} else {
					out[index] = output.get(k / 2);
				}
				index++;
				output.remove(Long.valueOf(nums[left]));
				left++;
			}
			right++;
		}
		return out;
	}

}
