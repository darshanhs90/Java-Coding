package Feb2021Leetcode;

import java.util.HashMap;

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
		if (s == null || s.length() == 0)
			return 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		numDecodings(0, s, map);
		return map.get(s);
	}

	public static int numDecodings(int index, String s, HashMap<String, Integer> map) {
		if (index == s.length())
			return 1;

		if (index >= s.length())
			return 0;

		String subString = s.substring(index);
		if (map.containsKey(subString))
			return map.get(subString);

		int count = 0;

		char c = s.charAt(index);
		if (c == '0') {
			map.put(subString, 0);
			return 0;
		}

		count += numDecodings(index + 1, s, map);

		if (index + 1 < s.length()) {
			String str = c + "" + s.charAt(index + 1);
			int val = Integer.parseInt(str);

			if (val >= 10 && val <= 26) {
				count += numDecodings(index + 2, s, map);
			}
		}

		map.put(subString, count);
		return count;
	}
}
