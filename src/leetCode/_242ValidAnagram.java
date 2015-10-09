package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/valid-anagram/
 */

public class _242ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		else{
			char sArray[]=s.toCharArray();
			char tArray[]=t.toCharArray();
			Arrays.sort(sArray);
			Arrays.sort(tArray);
			for (int i = 0; i < tArray.length; i++) {
				if(sArray[i]!=tArray[i])
				{
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
	}
}