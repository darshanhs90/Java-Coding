package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0349IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
		}

		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				output.add(nums2[i]);
				map.remove(nums2[i]);
			}
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}
}
