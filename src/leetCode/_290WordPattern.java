package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/word-pattern/
 */

public class _290WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		String strArray[]=str.split(" ");
		if(pattern.length()!=strArray.length)
			return false;
		else{
			HashMap<Character, String> charMap=new HashMap<>();
			for (int i = 0; i < pattern.length(); i++) {
				Character element=pattern.charAt(i);
				if(charMap.containsKey(element))
				{
					if(!(charMap.get(element).contentEquals(strArray[i])))
						return false;
				}
				else{
					charMap.put(element,strArray[i]);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog cat cat dog"));
		System.out.println(wordPattern("abba","dog cat cat fish"));
		System.out.println(wordPattern("aaaa","dog cat cat dog"));
		System.out.println(wordPattern("abba","dog dog dog dog"));
		
	}
}