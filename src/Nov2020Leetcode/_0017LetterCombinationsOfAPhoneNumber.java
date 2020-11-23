package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0017LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("2"));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}

		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		dfs(map, digits, "", list);
		return list;
	}

	public static void dfs(HashMap<Character, String> map, String digits, String currString, List<String> list) {
		if (digits.length() == 0) {
			list.add(currString);
			return;
		}
		char c = digits.charAt(0);
		String phoneString = map.get(c);
		for (int i = 0; i < phoneString.length(); i++) {
			dfs(map, digits.substring(1), currString + phoneString.charAt(i), list);
		}
	}
}
