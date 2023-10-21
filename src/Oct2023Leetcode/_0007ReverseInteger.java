package Oct2023Leetcode;

public class _0007ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
		}
		StringBuilder sb = new StringBuilder(String.valueOf(x));
		if (isNegative) {
			sb.deleteCharAt(0);
		}
		String str = sb.reverse().toString();
		if (isNegative) {
			str = "-" + str;
		}
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
}
