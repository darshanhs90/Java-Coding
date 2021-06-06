package June2021GoogLeetcode;

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
		dfs(0, s, map);
		return map.get(s);
	}

	public static int dfs(int index, String s, HashMap<String, Integer> map) {
		if (index == s.length())
			return 1;
		if (index >= s.length())
			return 0;

		String str = s.substring(index);
		if (map.containsKey(str))
			return map.get(str);

		int val = 0;
		char c = s.charAt(index);

		if (c == '0') {
			map.put(str, 0);
			return 0;
		}

		val += dfs(index + 1, s, map);

		if (index + 1 < s.length()) {
			String sub = c + "" + s.charAt(index + 1);
			int parsed = Integer.parseInt(sub);
			if (parsed >= 10 && parsed <= 26) {
				val += dfs(index + 2, s, map);
			}
		}

		map.put(str, val);
		return val;
	}
}
