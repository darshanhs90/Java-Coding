package Leetcode2020Nov;

import java.util.HashMap;

public class _1346CheckIfNAndItsDoubleExist {
	public static void main(String[] args) {
		System.out.println(checkIfExist(new int[] { 10, 2, 5, 3 }));
		System.out.println(checkIfExist(new int[] { 7, 1, 14, 11 }));
		System.out.println(checkIfExist(new int[] { 31, 1, 7, 11 }));
		System.out.println(checkIfExist(new int[] { 0, 0 }));
		System.out.println(checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
	}

	public static boolean checkIfExist(int[] arr) {
		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.compute(arr[i], (key, val) -> val == null ? 1 : val + 1);
			if (arr[i] / 2 == 0 || arr[i] * 2 == 0) {
				if (set.containsKey(arr[i]) && set.get(arr[i]) != 1)
					return true;
			} else if (arr[i] % 2 == 0 && set.containsKey(arr[i] / 2)) {
				return true;
			} else if (set.containsKey(arr[i] * 2))
				return true;
		}
		return false;
	}
}
