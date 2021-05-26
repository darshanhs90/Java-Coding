package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class _0349IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> output = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i]) && !output.contains(nums2[i])) {
				output.add(nums2[i]);
			}
		}
		int[] out = new int[output.size()];
		Iterator<Integer> iter = output.iterator();
		for (int i = 0; i < out.length; i++) {
			out[i] = iter.next();
		}
		return out;
	}
}
