package Feb2021Leetcode;

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
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			char c = s.charAt(i);
			if (pMap.containsKey(c) && isMatchingString(s, i, p.length(), pMap)) {
				output.add(i);
			}
		}
		return output;
	}

	public static boolean isMatchingString(String s, int index, int pLength, HashMap<Character, Integer> pMap) {

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();

		for (int i = index; i < index + pLength; i++) {

			char c = s.charAt(i);
			if (!pMap.containsKey(c) || (sMap.containsKey(c) && sMap.get(c).intValue() == pMap.get(c).intValue()))
				return false;
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		return true;
	}

}
