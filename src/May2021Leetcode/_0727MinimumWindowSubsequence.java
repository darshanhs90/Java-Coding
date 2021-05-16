package May2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0727MinimumWindowSubsequence {
	public static void main(String[] args) {
		System.out.println(minWindow("abcdebdde", "bde"));
		System.out.println(minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
	}

	public static String minWindow(String S, String T) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			tMap.compute(T.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		int left = 0, right = 0, minLength = Integer.MAX_VALUE;
		String minString = "";
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();

		while (right < S.length()) {
			char c = S.charAt(right);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			while (isMapEqual(sMap, tMap)) {

				int length = right - left + 1;
				if (length < minLength) {
					minLength = length;
					minString = S.substring(left, right + 1);
				} else if (length == minLength) {
					String str = S.substring(left, right + 1);
					minString = str.compareTo(minString) < 0 ? str : minString;
				}
				c = S.charAt(left);
				sMap.put(c, sMap.get(c) - 1);
				if (sMap.get(c) == 0)
					sMap.remove(c);

				left++;
			}
			right++;
		}
		return minString;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()))
				return false;

			if (sMap.get(entry.getKey()).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}

}
