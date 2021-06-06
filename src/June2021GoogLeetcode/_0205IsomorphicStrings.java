package June2021GoogLeetcode;

import java.util.HashMap;

public class _0205IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (!map1.containsKey(c1) && !map2.containsKey(c2)) {
				map1.put(c1, c2);
				map2.put(c2, c1);
			} else if (map1.containsKey(c1) && map2.containsKey(c2)) {
				if (map1.get(c1) != c2)
					return false;

				if (map2.get(c2) != c1)
					return false;
			} else {
				return false;
			}
		}
		return true;
	}
}
