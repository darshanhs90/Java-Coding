package Nov2020Leetcode;

import java.util.HashMap;

public class _0290WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> set1 = new HashMap<Character, String>();
		String[] arr = s.split(" ");
		if (arr.length != pattern.length())
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (set1.containsKey(c) && !set1.get(c).equals(arr[i])) {
				return false;
			}
			set1.put(c, arr[i]);
		}

		HashMap<String, Character> set2 = new HashMap<String, Character>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (set2.containsKey(arr[i]) && set2.get(arr[i]) != c) {
				return false;
			}
			set2.put(arr[i], c);
		}
		return true;
	}
}
