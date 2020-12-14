package Nov2020_GoogPrep;

public class _071ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(0));
	}

	public static int reverse(int x) {
		boolean isPositive = true;
		if (x < 0) {
			isPositive = false;
			x = -1 * x;
		}
		StringBuilder sb = new StringBuilder(String.valueOf(x));
		sb = sb.reverse();
		if (!isPositive)
			sb.insert(0, "-");
		try {
			int val = Integer.parseInt(sb.toString());
			return val;
		} catch (Exception e) {
			return 0;
		}
	}
}
