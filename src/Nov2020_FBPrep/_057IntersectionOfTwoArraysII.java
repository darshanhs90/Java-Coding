package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _057IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null | nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		HashMap<Integer, Integer> elementsMap = new HashMap<Integer, Integer>();
		List<Integer> outputList = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			elementsMap.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (elementsMap.containsKey(nums2[i]) && elementsMap.get(nums2[i]) > 0) {
				outputList.add(nums2[i]);
				elementsMap.computeIfPresent(nums2[i], (k, v) -> v - 1);
			}
		}

		int[] output = new int[outputList.size()];
		int index = 0;
		for (int number : outputList) {
			output[index++] = number;
		}
		return output;
	}
}
