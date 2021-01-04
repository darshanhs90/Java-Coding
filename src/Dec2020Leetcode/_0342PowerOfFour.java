package Dec2020Leetcode;

public class _0342PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(5));
	}

	public static boolean isPowerOfFour(int n) {
		return n > 0 && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
	}

}
