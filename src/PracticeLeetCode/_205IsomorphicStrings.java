package PracticeLeetCode;

import java.util.HashMap;

public class _205IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> reverseMap = new HashMap<Character, Character>();

		if(s.length() != t.length())
		{
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(map.containsKey(c1))
			{
				if(map.get(c1) != c2)
				{
					return false;
				}
			}
			else {
				map.put(c1, c2);
			}
			
			if(reverseMap.containsKey(c2))
			{
				if(reverseMap.get(c2) != c1)
				{
					return false;
				}
			}
			else {
				reverseMap.put(c2, c1);
			}
		}
		return true;
	}

}