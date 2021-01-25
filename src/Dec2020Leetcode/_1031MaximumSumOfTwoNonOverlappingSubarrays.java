package Dec2020Leetcode;

import java.util.Arrays;

public class _1031MaximumSumOfTwoNonOverlappingSubarrays {
	public static void main(String[] args) {
		System.out.println(maxSumTwoNoOverlap(new int[] { 0, 6, 5, 2, 2, 5, 1, 9, 4 }, 1, 2));
		System.out.println(maxSumTwoNoOverlap(new int[] { 3, 8, 1, 3, 2, 1, 8, 9, 0 }, 3, 2));
		System.out.println(maxSumTwoNoOverlap(new int[] { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 }, 4, 3));
		System.out.println(maxSumTwoNoOverlap(new int[] { 1, 0, 1 }, 1, 1));
	}

	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int[] sum = new int[A.length + 1];
		sum[0] = 0;
		for (int i = 0; i < A.length; i++) {
			sum[i + 1] = A[i] + sum[i];
		}

		System.out.println(Arrays.toString(sum));
		int maxVal = 0;
		// L followed by M
		for (int i = -1; i < A.length; i++) {
			if (i + L < A.length) {
				int lVal = sum[i + L + 1] - sum[i + 1];
				for (int j = i + L; j < A.length; j++) {
					if (j + M < A.length) {
						int rVal = sum[j + M + 1] - sum[j + 1];
						maxVal = Math.max(maxVal, lVal + rVal);
					}
				}
			}
		}

		// M followed by L
		for (int i = -1; i < A.length; i++) {
			if (i + M < A.length) {
				int lVal = sum[i + M + 1] - sum[i + 1];
				for (int j = i + M + 1; j < A.length; j++) {
					if (j + L < A.length) {
						int rVal = sum[j + L + 1] - sum[j + 1];
						maxVal = Math.max(maxVal, lVal + rVal);
					}
				}
			}
		}

		return maxVal;
	}

}
