package Jan2021Leetcode;

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
		List<Double> output = new ArrayList<Double>();

		int left = 0, right = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (right < nums.length) {
			if (list.size() == k - 1) {
				list.add(nums[right]);
				Collections.sort(list);
				if (k % 2 == 0) {
					long sum = list.get(k / 2 - 1);
					sum += list.get(k / 2);
					output.add(sum / (double) 2);
				} else {
					output.add((double) list.get(k / 2));
				}
				list.remove(Integer.valueOf(nums[left]));
				// remove left
				left++;
			} else {
				list.add(nums[right]);
			}
			right++;
		}

		double[] out = new double[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

}
