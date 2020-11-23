package Nov2020Leetcode;

public class _0172FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(10));
		System.out.println(trailingZeroes(25));
		System.out.println(trailingZeroes(26));
	}

	public static int trailingZeroes(int n) {
		int numOf5s = 0;
		while (n >= 5) {
			numOf5s += n / 5;
			n = n / 5;
		}
		return numOf5s;
	}
}
