package Nov2020Leetcode;

public class _0231PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(3));
		System.out.println(isPowerOfTwo(4));
		System.out.println(isPowerOfTwo(5));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		int val = n & (n - 1);
		return val == 0;
	}
}
