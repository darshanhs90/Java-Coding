package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("23"));
	}
	static HashMap<Character, String> map=new HashMap<>();
	static List<String> outputList;
	public static List<String> letterCombinations(String digits) {
		outputList=new ArrayList<>();
		if(digits==null||digits.length()==0)
			return outputList;	
		map=new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		populateList("",digits);
		return outputList;
	}
	private static void populateList(String prefix,String digits) {
		if(digits.length()==0)
		{
			outputList.add(prefix);
			return;
		}
		char c=digits.charAt(0);
		String str=map.get(c);
		for (int i = 0; i < str.length(); i++) {
			populateList(prefix+str.charAt(i), digits.substring(1));
		}
	}


}
