package FacebookPrep;

import java.util.HashMap;
import java.util.Map;

public class _0076MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			tMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		int minLength = Integer.MAX_VALUE;
		String maxString = "";
		int left = 0, right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);

				while (mapIsEqual(tMap, sMap)) {
					String currStr = s.substring(left, right + 1);
					if (currStr.length() < minLength) {
						maxString = currStr;
						minLength = currStr.length();
					}
					char c1 = s.charAt(left);
					if (tMap.containsKey(c1)) {
						sMap.put(c1, sMap.get(c1) - 1);
						if (sMap.get(c1).intValue() == 0)
							sMap.remove(c1);
					}
					left++;
				}
			}
			right++;
		}

		return maxString;
	}

	public static boolean mapIsEqual(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap) {
		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			char c = entry.getKey();
			if (!sMap.containsKey(c))
				return false;
			if (sMap.get(c).intValue() < tMap.get(c).intValue())
				return false;
		}
		return true;
	}
}
