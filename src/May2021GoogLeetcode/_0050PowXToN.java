package May2021GoogLeetcode;

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
		return calc(x, N);
	}

	public static double calc(double x, long n) {
		if (n == 0)
			return 1;
		double val = calc(x, n / 2);
		if (n % 2 == 0) {
			return val * val;
		} else {
			return val * val * x;
		}
	}

}
