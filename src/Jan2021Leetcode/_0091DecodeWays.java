package Jan2021Leetcode;

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

	static int count = 0;

	public static int numDecodings(String s) {
		count = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		numOfDecodings(0, s, map);
		return count;
	}

	public static int numOfDecodings(int index, String s, HashMap<String, Integer> map) {
		if (index == s.length()) {
			count++;
			return 1;
		}
		if (index > s.length())
			return 0;

		String str = s.substring(index);
		if (map.containsKey(str)) {
			count += map.get(str);
			return map.get(str);
		}

		char c = s.charAt(index);
		if (c == '0') {
			map.put(s.substring(index), 0);
			return 0;
		}
		int sum = numOfDecodings(index + 1, s, map);

		if (index + 1 < s.length()) {
			int val = Integer.parseInt(c + "" + s.charAt(index + 1));
			if (val > 9 && val < 27) {
				sum += numOfDecodings(index + 2, s, map);
			}
		}
		map.put(str, sum);
		return sum;
	}
}
