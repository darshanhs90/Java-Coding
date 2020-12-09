package Dec2020_HackerRankPrepKit;

import java.util.HashSet;

public class _011TwoStrings {

	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world"));
		System.out.println(twoStrings("hi", "world"));
	}

	static String twoStrings(String s1, String s2) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s1.length(); i++) {
			set.add(s1.charAt(i));
		}
		for (int i = 0; i < s2.length(); i++) {
			if (set.contains(s2.charAt(i))) {
				return "YES";
			}
		}
		return "NO";
	}
}
