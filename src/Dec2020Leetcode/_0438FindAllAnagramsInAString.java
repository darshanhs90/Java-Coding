package Dec2020Leetcode;

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
		int kSize = p.length();
		int left = 0, right = 0;
		List<Integer> output = new ArrayList<Integer>();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			sMap.compute(s.charAt(right), (k, v) -> v == null ? 1 : v + 1);
			if (right - left+1 == kSize) {
				if (mapisEqual(sMap, pMap))
					output.add(left);
				sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
				if (sMap.get(s.charAt(left)) == 0)
					sMap.remove(s.charAt(left));
				left++;
			}
			right++;
		}
		return output;
	}

	public static boolean mapisEqual(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
		for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
			if (!m1.containsKey(entry.getKey()) || m1.get(entry.getKey()).intValue() != entry.getValue().intValue())
				return false;
		}
		return true;
	}

}
