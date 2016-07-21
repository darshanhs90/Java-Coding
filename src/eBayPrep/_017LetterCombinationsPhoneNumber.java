package eBayPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _017LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		letterCombinations("67");
	}
	static HashMap<Character, String> map;
	static HashMap<String, String> tempMap;
	static ArrayList<String> output;
	public static List<String> letterCombinations(String digits) {
		map = new HashMap<Character, String>();
		tempMap = new HashMap<String, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', "");
		output=new ArrayList<>();
		printCombinations(digits,"");
		return output;
	}
	private static void printCombinations(String digits, String str) {
		if(digits.length()==0)
		{
			System.out.println(str);
			return;	
		}
		char c=digits.charAt(0);
		String strn=map.get(c);
		for (int i = 0; i < strn.length(); i++) {
			str+=strn.charAt(i);
			printCombinations(digits.substring(1), str);
			str=str.substring(0, str.length()-1);
		}
	}

}
