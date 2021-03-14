package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0438FindAllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
		System.out.println(findAnagrams("aaaaaaa", "a"));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> out = new ArrayList<Integer>();
		if (p.length() > s.length())
			return out;

		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		int left = 0, right = 0;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			if (right >= p.length()-1) {
				if (mapEquals(sMap, pMap)) {
					out.add(left);
				}
				char leftChar = s.charAt(left);
				sMap.put(leftChar, sMap.get(leftChar) - 1);
				if (sMap.get(leftChar) == 0)
					sMap.remove(leftChar);

				left++;
			}
			right++;
		}
		return out;
	}

	public static boolean mapEquals(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap) {
		for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()).intValue() != entry.getValue().intValue())
				return false;
		}
		return true;
	}

}
