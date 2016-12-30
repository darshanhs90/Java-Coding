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
	static List<String> outputList;
	public static List<String> letterCombinations(String digits) {
		map=new HashMap<>();
		map.put('0', "");
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		outputList=new ArrayList<>();
		dfs(0,"",digits);
		return outputList;
	}
	private static void dfs(int index,String prefix, String digits) {
		if(digits==null||digits.length()==0)
			return;
		if(index>digits.length()-1){
			outputList.add(prefix);
			return;
		}
		char c=digits.charAt(index);
		String st=map.get(c);
		for (int i = 0; i < st.length(); i++) {
			dfs(index+1,prefix+st.charAt(i),digits);
		}
	}

}
