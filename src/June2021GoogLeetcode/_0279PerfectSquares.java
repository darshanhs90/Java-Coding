package June2021GoogLeetcode;

import java.util.Arrays;

public class _0279PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		int maxIndex = (int) (Math.sqrt(n)) + 1;
		int[] arr = new int[maxIndex];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i * i;
		}

		int[] out = new int[n + 1];
		Arrays.fill(out, n + 2);
		out[0] = 0;

		for (int i = 1; i < out.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > i)
					break;

				out[i] = Math.min(out[i], 1 + out[i - arr[j]]);
			}
		}
		return out[n];
	}

}
