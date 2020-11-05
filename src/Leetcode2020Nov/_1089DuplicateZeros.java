package Leetcode2020Nov;

public class _1089DuplicateZeros {
	public static void main(String[] args) {
		duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
		duplicateZeros(new int[] { 1, 2, 3 });
	}

	public static void duplicateZeros(int[] arr) {
		int index = 0;
		while (index < arr.length) {
			if (arr[index] == 0) {
				moveArray(arr, index);
				index += 2;
			} else {
				index++;
			}
		}
	}

	public static void moveArray(int[] arr, int index) {
		for (int i = arr.length - 1; i > index + 1; i--) {
			arr[i] = arr[i - 1];
		}
		if (index + 1 < arr.length)
			arr[index + 1] = 0;
	}
}
