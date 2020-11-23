package Nov2020Leetcode;

public class _0007ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		StringBuilder num = new StringBuilder(x + "");
		if (num.length() == 1) {
			return x;
		}

		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			num = num.deleteCharAt(0);
		}
		num = num.reverse();
		while (num.length() > 0 && num.charAt(0) == '0') {
			num = num.deleteCharAt(0);
		}

		try {
			return isNegative ? -1 * Integer.parseInt(num.toString()) : Integer.parseInt(num.toString());
		} catch (Exception e) {
			return 0;
		}
	}
}
