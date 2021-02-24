package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _0496NextGreaterElementI {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {

			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}

		return nums1;
	}

}
