package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
		for (int val = A.length; val > 0; val--) {
			int index = findIndex(val, A);
			out.add(index + 1);
			reverse(0, index, A);
			out.add(val);
			reverse(0, val - 1, A);
		}
		System.out.println(Arrays.toString(A));
		return out;
	}

	public static void reverse(int left, int right, int[] A) {
		while (left < right) {
			swap(left, right, A);
			left++;
			right--;
		}
	}

	public static void swap(int left, int right, int[] A) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}

	public static int findIndex(int val, int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == val)
				return i;
		}
		return -1;
	}
}
