package Dec2020Leetcode;

import java.util.Arrays;

public class _0907SumOfSubarrayMinimums {
	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
		System.out.println(sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 }));
		System.out.println(sumSubarrayMins(new int[] { 71, 55, 82, 55 }));
	}

	public static int sumSubarrayMins(int[] A) {
		long res = 0, mod = (int) 1e9 + 7;
		int n = A.length, left[] = new int[n], right[] = new int[n];

		for (int i = 0; i < A.length; i++) {
			int count = 1;
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] <= A[j])
					count++;
				else
					break;
			}
			right[i] = count;
		}

		for (int i = 0; i < A.length; i++) {
			int count = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] < A[j])
					count++;
				else
					break;
			}
			left[i] = count;
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for (int i = 0; i < n; ++i)
			res = (res + (long) A[i] * left[i] * right[i]) % mod;
		return (int) res;
	}
}
