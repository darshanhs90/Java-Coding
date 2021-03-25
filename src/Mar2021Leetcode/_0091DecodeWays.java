package Mar2021Leetcode;

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
		decodings(0, s, map);
		return map.containsKey(s) ? map.get(s) : 0;
	}

	public static int decodings(int index, String s, HashMap<String, Integer> map) {
		if (index == s.length())
			return 1;
		if (index >= s.length())
			return 0;

		String str = s.substring(index);
		if (map.containsKey(str))
			return map.get(str);

		int count = 0;
		char c = s.charAt(index);
		if (c == '0')
			return 0;
		else
			count += decodings(index + 1, s, map);

		if (index + 1 < s.length()) {
			Integer val = Integer.parseInt(c + "" + s.charAt(index + 1));
			if (val >= 10 && val <= 26) {
				count += decodings(index + 2, s, map);
			}
		}

		map.put(str, count);
		return count;
	}
}
