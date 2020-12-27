package Dec2020Leetcode;

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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return decode(0, s, map);
	}

	public static int decode(int index, String s, HashMap<String, Integer> map) {
		if (map.containsKey(s.substring(index)))
			return map.get(s.substring(index));

		if (index == s.length() - 1 && s.charAt(index) != '0' || index == s.length()) {
			return 1;
		}
		if (index > s.length())
			return 0;

		int count = 0;
		char c = s.charAt(index);
		if (c >= '1' && c <= '9') {
			count = decode(index + 1, s, map);
		} else {
			return 0;
		}

		if (index + 1 < s.length()) {
			String str = s.charAt(index) + "" + s.charAt(index + 1);
			int val = Integer.parseInt(str);
			if (val > 9 && val < 27) {
				count += decode(index + 2, s, map);
			}
		}

		map.put(s.substring(index), count);

		return count;
	}
}
