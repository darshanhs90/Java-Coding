package April2021Leetcode;

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
		List<Integer> output = new ArrayList<Integer>();
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		int left = 0, right = 0;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			sMap.compute(s.charAt(right), (k, v) -> v == null ? 1 : v + 1);
			if (right >= p.length() - 1) {
				if (mapIsEqual(sMap, pMap)) {
					output.add(left);
				}
				char c1 = s.charAt(left);
				sMap.put(c1, sMap.get(c1) - 1);
				if (sMap.get(c1) == 0)
					sMap.remove(c1);
				left++;
			}
			right++;
		}
		return output;
	}

	public static boolean mapIsEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap) {
		if (pMap.size() != sMap.size())
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
