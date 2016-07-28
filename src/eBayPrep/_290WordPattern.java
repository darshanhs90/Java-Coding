package eBayPrep;

import java.util.HashMap;

public class _290WordPattern{
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));

	}
	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> charMap=new HashMap<>();
		HashMap<String, Character> stringMap=new HashMap<>();
		String arr[]=str.split(" ");
		if(arr.length!=pattern.length())
			return false;
		for (int i = 0; i < arr.length; i++) {
			char c=pattern.charAt(i);
			str=arr[i];
			if(charMap.containsKey(c))
			{
				if(!charMap.get(c).contentEquals(str))
					return false;
			}
			else{
				charMap.put(c, str);
			}

			if(stringMap.containsKey(str))
			{
				if(stringMap.get(str)!=c)
					return false;
			}
			else{
				stringMap.put(str, c);
			}

		}
		return true;
	}


}

