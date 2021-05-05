package May2021PrepLeetcode;

public class _0050PowXToN {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

	public static double myPow(double x, int n) {
		long N = n;
		if (n < 0) {
			N = -N;
			x = 1 / x;
		}
		double res = 1;
		double current_product = x;
		for (long i = N; i > 0; i = i / 2) {
			if (i % 2 == 1) {
				res = res * current_product;
			}
			current_product = current_product * current_product;
		}
		return res;
	}

}
