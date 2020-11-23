package Nov2020Leetcode;

public class _0693BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		System.out.println(hasAlternatingBits(5));
		System.out.println(hasAlternatingBits(7));
		System.out.println(hasAlternatingBits(11));
		System.out.println(hasAlternatingBits(10));
		System.out.println(hasAlternatingBits(3));
	}

	public static boolean hasAlternatingBits(int n) {
		n = n ^ n >> 1;
		n = n & n + 1;
		return n == 0;
	}
}
