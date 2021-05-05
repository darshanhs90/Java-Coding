package May2021PrepLeetcode;

public class _0029DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(10, 3));
		System.out.println(divide(7, -3));
		System.out.println(divide(0, 1));
		System.out.println(divide(1, 1));

	}

	public static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		boolean isDividendNeg = false;
		boolean isDivisorNeg = false;
		if (dividend < 0) {
			isDividendNeg = true;
			dividend = -dividend;
		}

		if (divisor < 0) {
			isDivisorNeg = true;
			divisor = -divisor;
		}

		int count = 0;
		while (dividend - divisor >= 0) {
			dividend = dividend - divisor;
			count++;
		}

		if ((isDividendNeg && isDivisorNeg) || (!isDividendNeg && !isDivisorNeg)) {
			return count;
		}
		return -count;
	}

}
