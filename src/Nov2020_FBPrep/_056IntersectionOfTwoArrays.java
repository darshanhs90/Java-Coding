package Nov2020_FBPrep;

import java.util.Arrays;
import java.util.HashSet;

public class _056IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null | nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		HashSet<Integer> elementsSet = new HashSet<Integer>();
		HashSet<Integer> outputSet = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			elementsSet.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (elementsSet.contains(nums2[i]) && !outputSet.contains(nums2[i])) {
				outputSet.add(nums2[i]);
			}
		}

		int[] output = new int[outputSet.size()];
		int index = 0;
		for (int number : outputSet) {
			output[index++] = number;
		}
		return output;
	}
}
