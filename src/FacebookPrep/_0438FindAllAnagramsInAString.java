package FacebookPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0438FindAllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
		System.out.println(findAnagrams("aaaaaaa", "a"));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<Integer>();
		if (s == null || p == null || s.length() == 0 || p.length() == 0)
			return output;
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			char c = s.charAt(i);
			if (pMap.containsKey(c)) {
				if (mapIsEqual(i, s, p, pMap)) {
					output.add(i);
				}
			}
		}
		return output;
	}

	public static boolean mapIsEqual(int index, String s, String p, HashMap<Character, Integer> pMap) {

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = index; i < index + p.length(); i++) {
			char c = s.charAt(i);
			if (!pMap.containsKey(c) || (sMap.containsKey(c) && sMap.get(c) >= pMap.get(c)))
				return false;
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		return true;
	}

}
