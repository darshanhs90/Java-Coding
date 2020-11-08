package Leetcode2020Nov;

public class _0326PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(45));
	}

	public static boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		else if (n == 1)
			return true;

		int val = 3;
		while (val < n) {
			val = val * 3;
		}
		return val == n;
	}
}
