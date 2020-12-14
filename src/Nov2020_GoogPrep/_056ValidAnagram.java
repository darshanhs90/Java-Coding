package Nov2020_GoogPrep;

import java.util.HashMap;
import java.util.Map;

public class _056ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			sMap.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		if (sMap.size() != tMap.size()) {
			return false;
		} else {
			for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
				if (!tMap.containsKey(entry.getKey()) || tMap.get(entry.getKey()).intValue() != entry.getValue().intValue())
					return false;
			}
		}
		return true;
	}
}
