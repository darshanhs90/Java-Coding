package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("23"));
	}
	static Map<Character,String> map;
	public static List<String> letterCombinations(String digits) {
		List<String> outputList=new ArrayList<>();
		if(digits==null||digits.length()==0)
			return outputList;
		map=new HashMap<>();
		map.put('1', "1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		getLetterCombinations(new StringBuilder(),digits,0,outputList);
		return outputList;
	}
	private static void getLetterCombinations(StringBuilder prefix,String digits, int index, List<String> outputList) {
		if(index>digits.length()-1){
			outputList.add(prefix.toString());
			return;
		}
		String str=map.get(digits.charAt(index));
		for (int i = 0; i < str.length(); i++) {
			prefix.append(str.charAt(i));
			getLetterCombinations(prefix, digits, index+1, outputList);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}

}
