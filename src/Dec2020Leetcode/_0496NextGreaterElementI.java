package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _0496NextGreaterElementI {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] output = new int[nums1.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {
			int nextGreater = -1;
			for (int j = i + 1; j < nums2.length; j++) {
				if (nums2[j] > nums2[i]) {
					nextGreater = nums2[j];
					break;
				}
			}
			map.put(nums2[i], nextGreater);
		}

		for (int i = 0; i < nums1.length; i++) {
			output[i] = map.get(nums1[i]);
		}
		return output;
	}

}
