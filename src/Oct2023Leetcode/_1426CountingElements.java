package Oct2023Leetcode;

import java.util.HashSet;

public class _1426CountingElements {
	public static void main(String[] args) {
		System.out.println(countElements(new int[] { 1, 2, 3 })); // 2
		System.out.println(countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 })); // 0
		System.out.println(countElements(new int[] { 1, 2, 2, 3 })); // 3
		System.out.println(countElements(new int[] { 1, 1, 2, 2, 3 })); // 4
	}

	public static int countElements(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + 1)) {
				count++;
			}
		}
		return count;
	}
}
