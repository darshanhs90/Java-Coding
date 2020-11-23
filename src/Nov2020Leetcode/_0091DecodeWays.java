package Nov2020Leetcode;

public class _0091DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("1"));
		System.out.println(numDecodings("2101"));
		System.out.println(numDecodings("123123"));
	}

	public static int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		else if (s.contentEquals("0"))
			return 0;
		else if (s.length() == 1)
			return 1;
		return numDecodings("" + s.charAt(0), s.substring(1))
				+ numDecodings("" + s.charAt(0) + s.charAt(1), s.substring(2));
	}

	public static int numDecodings(String currStr, String s) {
		if ((Integer.parseInt(currStr) <= 0 || Integer.parseInt(currStr) > 26)
				|| (s.length() > 0 && s.charAt(0) == '0'))
			return 0;

		int count = 0;
		if (currStr.charAt(0) != '0' && Integer.parseInt(currStr) > 0 && Integer.parseInt(currStr) <= 26
				&& s.length() == 0) {
			count = 1;
		}

		if (s.length() > 0)
			count += numDecodings("" + s.charAt(0), s.substring(1));
		if (s.length() > 1)
			count += numDecodings("" + s.substring(0, 2), s.substring(2));
		return count;
	}

}
