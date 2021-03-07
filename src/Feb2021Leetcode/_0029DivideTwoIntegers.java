package Feb2021Leetcode;

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

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		if (dividend < 0) {
			dividend = -dividend;
			isDividendNegative = true;
		}

		if (divisor < 0) {
			divisor = -divisor;
			isDivisorNegative = true;
		}

		int count = 0;
		while (dividend - divisor > 0) {

			dividend -= divisor;
			count++;
		}

		if (isDividendNegative && isDivisorNegative)
			return count;
		else if (isDividendNegative || isDivisorNegative)
			return -count;
		return count;
	}

}
