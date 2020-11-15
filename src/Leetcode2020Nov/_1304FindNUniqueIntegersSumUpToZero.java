package Leetcode2020Nov;

import java.util.Arrays;

public class _1304FindNUniqueIntegersSumUpToZero {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(5)));
		System.out.println(Arrays.toString(sumZero(3)));
		System.out.println(Arrays.toString(sumZero(0)));
	}

	public static int[] sumZero(int n) {
		if (n == 0)
			return new int[] { 0 };
		int[] output = new int[n];
		if (n % 2 == 0) {
			for (int i = 0; i < n / 2; i++) {
				output[i] = (i + 1);
				output[n - 1 - i] = -(i + 1);
			}
		} else {
			for (int i = 0; i < n / 2; i++) {
				output[i] = (i + 1);
				output[n - 1 - i] = -(i + 1);
			}
			output[n / 2] = 0;
		}
		return output;
	}
}
