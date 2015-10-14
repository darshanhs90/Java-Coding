package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/isomorphic-strings/
 */
public class _205IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> charMap=new HashMap<>();
		HashMap<Character, Character> charMapNew=new HashMap<>();
		
		StringBuffer sb=new StringBuffer();
		StringBuffer sbNew=new StringBuffer();
		
		for (int i = 0; i < s.length(); i++) {
			char sChar=s.charAt(i);
			char tChar=t.charAt(i);
			if(charMap.containsKey(sChar))
			{
				sb.append(charMap.get(sChar)+"");
			}
			else{
				charMap.put(sChar,tChar);
				sb.append(tChar);
			}
			if(charMapNew.containsKey(tChar))
			{
				sbNew.append(charMapNew.get(tChar)+"");
			}
			else{
				charMapNew.put(tChar,sChar);
				sbNew.append(sChar);
			}
		}
		return sb.toString().contentEquals(t) && sbNew.toString().contentEquals(s)?true:false;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab","aa"));
		System.out.println(isIsomorphic("egg","add"));
		System.out.println(isIsomorphic("foo","bar"));	
		System.out.println(isIsomorphic("paper","title"));		
	}
}