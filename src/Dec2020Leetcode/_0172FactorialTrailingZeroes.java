package Dec2020Leetcode;

public class _0172FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(10));
		System.out.println(trailingZeroes(25));
		System.out.println(trailingZeroes(26));
		System.out.println(trailingZeroes(30));
	}

	public static int trailingZeroes(int n) {
		int noOfZeros = 0;
		for (int i = 5; i <= n; i += 5) {
			int num = i;
			while (num % 5 == 0) {
				noOfZeros++;
				num /= 5;
			}
		}
		return noOfZeros;
	}
}
