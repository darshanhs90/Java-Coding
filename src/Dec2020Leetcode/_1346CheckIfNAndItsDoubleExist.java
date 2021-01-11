package Dec2020Leetcode;

import java.util.HashSet;

public class _1346CheckIfNAndItsDoubleExist {
	public static void main(String[] args) {
		System.out.println(checkIfExist(new int[] { 10, 2, 5, 3 }));
		System.out.println(checkIfExist(new int[] { 7, 1, 14, 11 }));
		System.out.println(checkIfExist(new int[] { 31, 1, 7, 11 }));
		System.out.println(checkIfExist(new int[] { 0, 0 }));
		System.out.println(checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
	}

	public static boolean checkIfExist(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				if (set.contains(arr[i] * 2) || set.contains(arr[i] / 2))
					return true;
			} else {
				if (set.contains(arr[i] * 2))
					return true;
			}
			set.add(arr[i]);
		}
		return false;
	}

}
