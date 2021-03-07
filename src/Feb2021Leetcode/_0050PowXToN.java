package Feb2021Leetcode;

public class _0050PowXToN {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

	public static double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			N = -N;
			x = 1 / x;
		}

		double ans = 1;
		for (long i = 1; i <= N; i++) {
			ans = ans * x;
		}
		return ans;
	}
}
