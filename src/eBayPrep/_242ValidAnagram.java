package eBayPrep;

public class _242ValidAnagram{
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("rat","car"));

	}
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		char c1[]=new char[127];
		char c2[]=new char[127];
		for (int i = 0; i < s.length(); i++) {
			c1[s.charAt(i)]++;
			c2[t.charAt(i)]++;
		}
		for (int i = 0; i < 127; i++) {
			if(c1[i]!=c2[i])
				return false;
		}
		return true;
	}
}

