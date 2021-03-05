package FacebookPrep;

public class _0029DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(10, 3));
		System.out.println(divide(7, -3));
		System.out.println(divide(0, 1));
		System.out.println(divide(1, 1));

	}

	public static int divide(int dividend, int divisor) {
		// Special case: overflow.
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		boolean isDividendNegative = dividend < 0;
		boolean isDivisorNegative = divisor < 0;

		if (isDividendNegative)
			dividend = -dividend;

		if (isDivisorNegative)
			divisor = -divisor;

		int count = 0;
		while (dividend - divisor >= 0) {
			dividend = dividend - divisor;
			count++;
		}

		if (isDividendNegative && isDivisorNegative)
			return count;
		if (isDivisorNegative || isDividendNegative)
			return -count;
		return count;
	}

}
