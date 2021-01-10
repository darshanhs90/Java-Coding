package Dec2020Leetcode;

public class _0985SumOfEvenNumbersAfterQueries {
	public static void main(String[] args) {
		System.out.println(sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 0 }, new int[] { -3, 1 }, new int[] { -4, 0 }, new int[] { 2, 3 } }));
	}

	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0)
				sum += A[i];
		}

		int[] out = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int newVal = queries[i][0];
			int newIndex = queries[i][1];
			if (A[newIndex] % 2 == 0) {
				sum -= A[newIndex];
			}
			A[newIndex] += newVal;
			if (A[newIndex] % 2 == 0) {
				sum += A[newIndex];
			}

			out[i] = sum;
		}
		return out;
	}
}
