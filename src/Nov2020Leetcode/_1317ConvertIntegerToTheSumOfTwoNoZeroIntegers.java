package Nov2020Leetcode;

import java.util.Arrays;

public class _1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNoZeroIntegers(2)));
		System.out.println(Arrays.toString(getNoZeroIntegers(11)));
		System.out.println(Arrays.toString(getNoZeroIntegers(10000)));
		System.out.println(Arrays.toString(getNoZeroIntegers(1010)));
	}

	public static int[] getNoZeroIntegers(int n) {
		int leftIndex = 1;
		int rightIndex = n - 1;
		while (leftIndex < rightIndex) {
			if (leftIndex % 10 != 0 && rightIndex % 10 != 0 && String.valueOf(leftIndex).indexOf('0') == -1 && String.valueOf(rightIndex).indexOf('0') == -1) {
				return new int[] { leftIndex, rightIndex };
			}
			leftIndex++;
			rightIndex--;
		}
		return new int[] { leftIndex, rightIndex };
	}
}
