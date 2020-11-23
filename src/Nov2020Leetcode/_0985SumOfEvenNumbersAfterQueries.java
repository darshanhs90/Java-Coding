package Nov2020Leetcode;

public class _0985SumOfEvenNumbersAfterQueries {
	public static void main(String[] args) {
		System.out.println(sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 0 }, new int[] { -3, 1 }, new int[] { -4, 0 }, new int[] { 2, 3 } }));
	}

	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int evenSum = 0;
		int[] evenSumArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			evenSum += A[i] % 2 == 0 ? A[i] : 0;
		}

		for (int i = 0; i < queries.length; i++) {
			int val = queries[i][0];
			int index = queries[i][1];

			if (A[index] % 2 == 0) {
				evenSum -= A[index];
			}

			A[index] += val;
			if (A[index] % 2 == 0) {
				evenSum += A[index];
			}
			evenSumArr[i] = evenSum;
		}
		return evenSumArr;
	}
}
