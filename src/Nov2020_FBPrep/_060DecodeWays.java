package Nov2020_FBPrep;

import java.util.HashMap;

public class _060DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("1"));
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return decode(0, s, map);
	}

	public static int decode(int index, String s, HashMap<Integer, Integer> map) {
		if (index == s.length())
			return 1;
		if (s.charAt(index) == '0')
			return 0;
		if (index == s.length() - 1)
			return 1;
		if (map.containsKey(index))
			return map.get(index);

		int ans = decode(index + 1, s, map);
		String st = s.charAt(index) + "" + s.charAt(index + 1);
		if (Integer.parseInt(st) > 0 && Integer.parseInt(st) <= 26) {
			ans += decode(index + 2, s, map);
		}
		map.put(index, ans);
		return ans;
	}

}
