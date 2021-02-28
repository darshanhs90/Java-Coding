package FacebookPrep;

public class _0091DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("1"));
		System.out.println(numDecodings("2101"));
		System.out.println(numDecodings("123123"));
	}

	static int decodings;

	public static int numDecodings(String s) {
		decodings = 0;
		numDecodings(0, s);
		return decodings;
	}

	public static void numDecodings(int index, String s) {
		if (index == s.length()) {
			decodings += 1;
			return;
		}
		if (index >= s.length())
			return;

		char c = s.charAt(index);
		if (c == '0')
			return;

		numDecodings(index + 1, s);

		if (index + 1 < s.length()) {
			String str = c + "" + s.charAt(index + 1);
			int val = Integer.parseInt(str);
			if(val>=10 && val<=26)
			{
				numDecodings(index + 2, s);
			}
		}
	}

}
