package Leetcode2020Nov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _0496NextGreaterElementI {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
		System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> ngtMap = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				ngtMap.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			if (ngtMap.containsKey(nums1[i])) {
				nums1[i] = ngtMap.get(nums1[i]);
			} else {
				nums1[i] = -1;
			}
		}
		return nums1;
	}
}
