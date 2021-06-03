package May2021GoogLeetcode;

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
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		int left = 0, right = 0;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		List<Integer> output = new ArrayList<Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			if (right >= p.length() - 1) {
				if (isMapEqual(sMap, pMap)) {
					output.add(left);
				}
				c = s.charAt(left);
				sMap.put(c, sMap.get(c) - 1);
				if (sMap.get(c) == 0)
					sMap.remove(c);
				left++;
			}
			right++;
		}
		return output;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap) {
		if (sMap.size() != pMap.size())
			return false;
		for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()))
				return false;
			if (sMap.get(entry.getKey()).intValue() != entry.getValue().intValue())
				return false;
		}
		return true;
	}

}
