package FacebookPrep;

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
		if (digits == null || digits.length() == 0)
			return list;

		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', "");

		dfs(0, digits, "", list, map);
		return list;
	}

	public static void dfs(int index, String digits, String currString, List<String> list,
			HashMap<Character, String> map) {
		if (index == digits.length()) {
			list.add(currString);
			return;
		}

		char c = digits.charAt(index);
		String str = map.get(c);
		if (str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				dfs(index + 1, digits, currString + str.charAt(i), list, map);
			}
		} else {
			dfs(index + 1, digits, currString, list, map);
		}
	}
}
