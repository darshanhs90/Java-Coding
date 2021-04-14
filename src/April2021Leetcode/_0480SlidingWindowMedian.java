package April2021Leetcode;

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
		List<Long> list = new ArrayList<Long>();
		double[] out = new double[nums.length - k + 1];
		int left = 0, right = 0, index = 0;
		while (right < nums.length) {
			list.add((long) nums[right]);
			if (list.size() == k) {
				Collections.sort(list);
				if (k % 2 == 0) {
					long sum = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1));
					out[index++] = sum / (double) 2;
				} else {
					out[index++] = list.get(list.size() / 2);
				}
				list.remove(Long.valueOf(nums[left++]));
			}
			right++;
		}
		return out;
	}

}
