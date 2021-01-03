package Dec2020Leetcode;

public class _0326PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(45));
		System.out.println(isPowerOfThree(3));
	}

	public static boolean isPowerOfThree(int n) {
		if (n < 1)
			return false;
		while (n % 3 == 0) {
			n = n / 3;
		}

		return n == 1;
	}

}
