package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
	}
	static Map<Character,String> map;
	static List<String> list;
	public static List<String> letterCombinations(String digits) {
		map=new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		list=new ArrayList<>();
		if(digits==null|digits.length()==0)
			return list;
		printLetterCombinations("",digits,digits.length());
		return list;
	}
	private static void printLetterCombinations(String prefix, String digits,int length) {
		if(prefix.length()==length||digits.length()==0){
			list.add(prefix);
			return;
		}
		char c=digits.charAt(0);
		String str=map.get(c);
		for (int j = 0; j < str.length(); j++) {
			prefix+=str.charAt(j);
			printLetterCombinations(prefix, digits.substring(1), length);
			prefix=prefix.substring(0,prefix.length()-1);
		}
	}
}
