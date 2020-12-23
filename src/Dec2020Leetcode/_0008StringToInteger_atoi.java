package Dec2020Leetcode;

public class _0008StringToInteger_atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("    -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("--24"));
		System.out.println(myAtoi("++24"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("-"));
	}

	public static int myAtoi(String s) {
		boolean signFound = false;
		boolean isNegative = false;
		StringBuilder sb = new StringBuilder();
		s = s.trim();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+') {
				if (sb.length() != 0)
					return 0;
				signFound = true;
				sb.append(c);
			} else if (c == '-') {
				if (sb.length() != 0)
					return 0;
				signFound = true;
				isNegative = true;
				sb.append(c);
			} else if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				if (sb.length() > 0)
					break;
				return 0;
			}
		}

		s = sb.toString();
		if (s.length() == 0 || signFound && s.length() == 1)
			return 0;

		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			if (isNegative)
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
	}
}
