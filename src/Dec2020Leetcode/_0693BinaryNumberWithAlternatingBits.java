package Dec2020Leetcode;

public class _0693BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		System.out.println(hasAlternatingBits(5));
		System.out.println(hasAlternatingBits(7));
		System.out.println(hasAlternatingBits(11));
		System.out.println(hasAlternatingBits(10));
		System.out.println(hasAlternatingBits(3));
	}

	public static boolean hasAlternatingBits(int n) {
		String str = Integer.toString(n, 2);
		if (str.length() < 2)
			return true;
		char prev = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != prev) {
				prev = c;
			} else {
				return false;
			}
		}
		return true;
	}

}
