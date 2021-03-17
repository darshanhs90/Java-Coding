package Feb2021Leetcode;

public class _0242ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			count[c1 - 'a']++;
			count[c2 - 'a']--;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
