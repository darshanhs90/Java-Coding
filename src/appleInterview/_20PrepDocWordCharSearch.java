package appleInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _20PrepDocWordCharSearch {
	public static void main(String[] args) {
		String words[] = new String[]{ "abc" , "baa" , "caan" , "an" , "banc" };
		char chars[] = new char[]{ 'a' , 'a' , 'n' , 'c' , 'b'};
		findAndPrintWords(words,chars);
	}

	private static void findAndPrintWords(String[] words, char[] chars) {
		HashMap<Integer,ArrayList<String>> longMap=new HashMap<>();
		int max=-1;
		ArrayList<String> aList;
		HashMap<Character,Integer> charCount=new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			if(charCount.containsKey(chars[i]))
				charCount.put(chars[i], charCount.get(chars[i])+1);
			else
				charCount.put(chars[i],1);
		}
		for (int i = 0; i < words.length; i++) {
			if(checkCounts(words[i],charCount)){
				max=Math.max(max, words[i].length());
				int length=words[i].length();
				if(longMap.containsKey(length))
				{
					aList=longMap.get(length);
				}
				else{
					aList=new ArrayList<String>();
				}
				aList.add(words[i]);
				longMap.put(length, aList);
			}
		}
		aList=longMap.get(max);
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}

	}

	private static boolean checkCounts(String string, HashMap<Character, Integer> charCount) {
		HashMap<Character, Integer> charCountNew=new HashMap<>();
		char[] chars=string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(charCountNew.containsKey(chars[i]))
				charCountNew.put(chars[i], charCountNew.get(chars[i])+1);
			else
				charCountNew.put(chars[i],1);
		}
		for (int i = 0; i < chars.length; i++) {
			if(!(charCount.containsKey(chars[i]) && charCountNew.get(chars[i])<=charCount.get(chars[i])))
			{
				return false;
			}
		}
		return true;
	}


}
