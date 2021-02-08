package Jan2021Leetcode;

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
		List<Integer> list = new ArrayList<Integer>();
		if (p.length() > s.length())
			return list;
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s.length() - p.length()+1; i++) {
			char c = s.charAt(i);
			if (pMap.containsKey(c) && checkMap(i, s, p, pMap)) {
				list.add(i);
			}
		}
		return list;
	}

	public static boolean checkMap(int index, String s, String p, HashMap<Character, Integer> pMap) {
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = index; i < index + p.length(); i++) {
			char c = s.charAt(i);
			if (!pMap.containsKey(c))
				return false;
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			if (sMap.get(c).intValue() > pMap.get(c).intValue())
				return false;
		}
		return true;
	}

}
