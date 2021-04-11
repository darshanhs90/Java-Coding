package April2021Leetcode;

public class _0050PowXToN {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

	public static double myPow(double x, int n) {
		long N = n;
		if (n < 0) {
			x = 1 / x;
			N = -N;
		}
		double res = 1;
		for (int i = 1; i <= N; i++) {
			res = res * x;
		}
		return res;
	}
}
