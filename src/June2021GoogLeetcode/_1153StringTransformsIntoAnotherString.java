package June2021GoogLeetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _1153StringTransformsIntoAnotherString {
	public static void main(String[] args) {
		System.out.println(canConvert("aabcc", "ccdee"));
		System.out.println(canConvert("leetcode", "codeleet"));
	}

	public static boolean canConvert(String str1, String str2) {
		if (str1.equals(str2))
			return true;
		if (str1.length() != str2.length())
			return false;
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);

			if (!map.containsKey(c1)) {
				map.put(c1, c2);
			} else {
				if (map.get(c1) != c2)
					return false;
			}
		}

		return new HashSet<Character>(map.values()).size() < 26;
	}
}
