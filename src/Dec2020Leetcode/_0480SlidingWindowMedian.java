package Dec2020Leetcode;

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
		List<Integer> list = new ArrayList<Integer>();
		int left = 0, right = 0;
		List<Double> outputList = new ArrayList<Double>();
		while (right < nums.length) {
			list.add(nums[right]);
			if (list.size() == k) {
				List<Integer> clone = new ArrayList<Integer>(list);
				Collections.sort(clone);
				if (k % 2 == 0) {
					Long sum = Long.valueOf(clone.get(k / 2 - 1));
					sum += clone.get(k / 2);
					outputList.add((sum) / (double) 2);
				} else {
					outputList.add((double) clone.get(k / 2));
				}
				list.remove(Integer.valueOf(nums[left]));
				left++;
			}
			right++;
		}

		double[] doubleOp = new double[outputList.size()];
		for (int i = 0; i < doubleOp.length; i++) {
			doubleOp[i] = outputList.get(i);
		}
		return doubleOp;
	}

}
