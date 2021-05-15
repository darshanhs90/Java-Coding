package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0969PancakeSorting {
	public static void main(String[] args) {
		System.out.println(pancakeSort(new int[] { 3, 2, 4, 1 }));
		// System.out.println(pancakeSort(new int[] { 1, 2, 3 }));
	}

	// 3241
	// 4231 -- 1324

	public static List<Integer> pancakeSort(int[] A) {

		List<Integer> out = new ArrayList<Integer>();
		for (int i = A.length; i >= 1; i--) {
			int index = findIndex(i, A);
			reverse(0, index, A);
			out.add(index + 1);
			reverse(0, i - 1, A);
			out.add(i);
		}
		return out;
	}

	public static void swap(int left, int right, int[] A) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}

	public static void reverse(int left, int right, int[] A) {
		while (left < right) {
			swap(left, right, A);
			left++;
			right--;
		}
	}

	public static int findIndex(int val, int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == val)
				return i;
		}
		return -1;
	}
}
