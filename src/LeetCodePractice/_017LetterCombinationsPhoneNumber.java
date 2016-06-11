package LeetCodePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _017LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("67"));
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
		if(digits.length()==0||digits==null)
			return output;
		int length=map.get(digits.charAt(0)).length();
		for (int i = 0; i < length; i++) {
			getCombinations(digits,"",0,i);
		}
		return output;
	}
	private static void getCombinations(String digits, String tempOutput,int stringIndex,int subIndex) {
		if(stringIndex>digits.length()-1){
			if(!tempMap.containsKey(tempOutput)){
				output.add(tempOutput);
				tempMap.put(tempOutput, tempOutput);
			}
			return;
		}
		else{
			int subStringlength=map.get(digits.charAt(stringIndex)).length();
			if(subIndex<=subStringlength-1)
			{
				tempOutput+=map.get(digits.charAt(stringIndex)).charAt(subIndex);
				for (int i = 0; i <=subStringlength; i++) {
					getCombinations(digits, tempOutput, stringIndex+1, i);
				}
			}
			if(stringIndex==digits.length()-1)
			{
				return;
			}
		}	
	}
}
