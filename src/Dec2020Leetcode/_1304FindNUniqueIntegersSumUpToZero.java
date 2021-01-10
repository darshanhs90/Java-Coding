package Dec2020Leetcode;

import java.util.Arrays;

public class _1304FindNUniqueIntegersSumUpToZero {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(5)));
		System.out.println(Arrays.toString(sumZero(3)));
		System.out.println(Arrays.toString(sumZero(0)));
	}

	public static int[] sumZero(int n) {
		int[] out = new int[n];
		if (n % 2 != 0) {
			out[0] = 0;
			int val = 1;
			for (int i = 1; i < out.length;) {
				out[i] = val;
				out[i + 1] = -val;
				i += 2;
				val += 1;
			}
		} else {
			int val = 1;
			for (int i = 0; i < out.length;) {
				out[i] = val;
				out[i + 1] = -val;
				i += 2;
				val += 1;
			}
		}
		return out;
	}

}
