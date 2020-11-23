package Nov2020Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _0349IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		HashSet<Integer> outputSet = new HashSet<Integer>();

		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i]) && !outputSet.contains(nums2[i])) {
				outputSet.add(nums2[i]);
			}
		}
		Object[] arr = outputSet.toArray();
		int[] out = new int[arr.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = (int) arr[i];
		}
		return out;
	}
}
