package LeetCodePractice;

import java.util.HashMap;

public class _205IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("add", "egg"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));

	}
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> charMap=new HashMap<>();
		if(s.length()!=t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if(charMap.containsKey(s.charAt(i)))
			{
				if(charMap.get(s.charAt(i))!=t.charAt(i))
					return false;
			}else{
				if(charMap.containsKey(t.charAt(i)))
					return false;
				charMap.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
}

