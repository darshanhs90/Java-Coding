package FacebookPortalPrep;

import java.util.HashMap;
import java.util.Map;

public class _0009Strings_MinimumLengthSubstrings {

	public static void main(String[] args) {
		System.out.println(minLengthSubstring("dcbefebce", "fd"));
	}

	public static int minLengthSubstring(String s, String t) {
		// Write your code here

		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		int left = 0, right = 0, minLength = Integer.MAX_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
				while (isMapEqual(tMap, sMap)) {
					minLength = Math.min(minLength, right - left + 1);
					char c1 = s.charAt(left);
					if (sMap.containsKey(c1)) {
						sMap.put(c1, sMap.get(c1) - 1);
						if (sMap.get(c1) == 0) {
							sMap.remove(c1);
						}
					}
					left++;
				}
			}
			right++;
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap) {
		if (tMap.size() != sMap.size())
			return false;

		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
