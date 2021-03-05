package FacebookPrep;

public class _0050PowXToN {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2.0, -2));
	}

	public static double myPow(double x, int n) {
		if (n == 1 || x == 1)
			return x;
		long Nval = n;
		if (Nval < 0) {
			x = 1 / x;
			Nval = -Nval;
		}

		double val = 1;
		for (long i = 0; i < Nval; i++) {
			val = val * x;
		}
		return val;
	}
}
