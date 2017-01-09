package PracticeLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _017LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("23"));
	}
	static HashMap<Character,String> map;
    public static List<String> letterCombinations(String digits) {
    	List<String> list=new ArrayList<>();
    	if(digits==null||digits.length()==0)
    		return list;
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
        dfs(0,"",digits,list);
        return list;
    }
	private static void dfs(int index,String string, String digits, List<String> list) {
		if(index>digits.length()-1)
		{
			list.add(string);
			return;
		}
		String newString=map.get(digits.charAt(index));
		for (int i = 0; i < newString.length(); i++) {
			dfs(index+1,string+newString.charAt(i),digits,list);
		}
	}

}
