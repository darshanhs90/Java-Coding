package April2021PrepLeetcode;

public class _0029DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(10, 3));
		System.out.println(divide(7, -3));
		System.out.println(divide(0, 1));
		System.out.println(divide(1, 1));

	}

	public static int divide(int dividend, int divisor) {
		boolean isDividendNegative = false;
		boolean isDivisorNegative = false;

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		if (dividend < 0) {
			isDividendNegative = true;
			dividend = -dividend;
		}

		if (divisor < 0) {
			isDivisorNegative = true;
			divisor = -divisor;
		}

		int count = 0;
		while (dividend - divisor >= 0) {
			count++;
			dividend = dividend - divisor;
		}

		if ((isDividendNegative && isDivisorNegative) || (!isDividendNegative && !isDivisorNegative))
			return count;
		return -count;
	}

}
