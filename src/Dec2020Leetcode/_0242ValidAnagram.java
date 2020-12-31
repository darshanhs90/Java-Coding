package Dec2020Leetcode;

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
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
