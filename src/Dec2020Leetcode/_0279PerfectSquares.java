package Dec2020Leetcode;

import java.util.Arrays;

public class _0279PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		if (n < 2)
			return n;
		int[] squares = new int[n + 1];
		Arrays.fill(squares, Integer.MAX_VALUE);
		squares[0] = 0;
		squares[1] = 1;

		for (int i = 2; i < squares.length; i++) {
			for (int j = 1; i - j * j >= 0; j++) {
				squares[i] = Math.min(squares[i], squares[i - j * j] + 1);
			}
		}
		return squares[n];
	}

}
