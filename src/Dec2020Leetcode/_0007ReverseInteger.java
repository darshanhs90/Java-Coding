package Dec2020Leetcode;

public class _0007ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		boolean isPositive = true;
		String str = "";
		if (x < 0) {
			isPositive = false;
			str = String.valueOf(x);
			str = str.substring(1);
		} else {
			str = String.valueOf(x);
		}

		StringBuilder sb = new StringBuilder(str);
		sb = sb.reverse();
		if (!isPositive) {
			sb.insert(0, "-");
		}

		try {
			return Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return 0;
		}

	}
}
