package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0658FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		int left = 0, right = arr.length - 1;
		while (right - left >= k) {
			if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
				left++;
			} else {
				right--;
			}
		}

		List<Integer> out = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			out.add(arr[i]);
		}
		return out;
	}

}
