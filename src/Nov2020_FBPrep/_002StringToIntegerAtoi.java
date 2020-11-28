package Nov2020_FBPrep;

public class _002StringToIntegerAtoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("   -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("--1"));
		System.out.println(myAtoi("+1"));
		System.out.println(myAtoi("++1"));
		System.out.println(myAtoi(""));
		System.out.println(myAtoi("+"));
	}

	static public int myAtoi(String s) {
		if (s == null || s.length() == 0)
			return 0;
		StringBuilder sb = new StringBuilder();
		s = s.trim();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (sb.length() == 0 && (c == '-' || c == '+'))
				sb = sb.append(c);
			else if (Character.isDigit(c)) {
				sb = sb.append(c);
			} else {
				break;
			}
		}
		if (sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-'))
			return 0;
		else if (sb.length() == 0)
			return 0;

		try {
			return Integer.parseInt(sb.toString());
		} catch (Exception e) {
			if (sb.charAt(0) == '-')
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
	}
}
