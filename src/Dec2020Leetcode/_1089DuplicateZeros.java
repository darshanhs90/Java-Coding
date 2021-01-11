package Dec2020Leetcode;

import java.util.Arrays;

public class _1089DuplicateZeros {
	public static void main(String[] args) {
		duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
		duplicateZeros(new int[] { 1, 2, 3 });
		duplicateZeros(new int[] { 0, 0, 0, 0, 0, 0, 0 });
	}

	public static void duplicateZeros(int[] arr) {
		int arrIndex = 0;
		int lastIndex = 0;
		while (lastIndex < arr.length) {
			if (arr[arrIndex] != 0) {
				lastIndex++;
				arrIndex++;
			} else {
				if (lastIndex + 2 <= arr.length) {
					arrIndex++;
					lastIndex += 2;
				} else {
					arr[lastIndex] = 0;
					break;
				}
			}
		}

		arrIndex--;
		lastIndex--;

		while (lastIndex >= 0 && arrIndex >= 0) {
			if (arr[arrIndex] != 0) {
				arr[lastIndex] = arr[arrIndex];
				lastIndex--;
				arrIndex--;
			} else {
				arr[lastIndex] = 0;
				lastIndex--;
				arr[lastIndex] = 0;
				lastIndex--;
				arrIndex--;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
