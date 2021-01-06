package Dec2020Leetcode;

public class _0396RotateFunction {

	public static void main(String[] args) {
		System.out.println(maxRotateFunction(new int[] { 4, 3, 2, 6 }));
	}

	public static int maxRotateFunction(int[] A) {
		int sum = 0;
		int prevF = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			prevF += i * A[i];
		}

		int maxVal = prevF;

		for (int i = A.length - 1; i >= 0; i--) {
			int currF = prevF + sum - A[i] * A.length;
			prevF = currF;
			maxVal = Math.max(prevF, maxVal);
		}
		return maxVal;
	}
}
