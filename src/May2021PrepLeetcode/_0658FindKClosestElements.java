package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0658FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> output = new ArrayList<Integer>();
		int low = 0, right = arr.length - 1;
		while (right - low >= k) {
			if (Math.abs(arr[low] - x) > Math.abs(arr[right] - x)) {
				low++;
			} else {
				right--;
			}
		}
		for (int i = low; i <= right; i++) {
			output.add(arr[i]);
		}
		return output;
	}

}
