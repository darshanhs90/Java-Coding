package April2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0350IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
		}
		int index = 0;
		for (int i = 0; i < nums2.length; i++) {

			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				nums2[index++] = nums2[i];
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}

		return Arrays.copyOfRange(nums2, 0, index);
	}
}
