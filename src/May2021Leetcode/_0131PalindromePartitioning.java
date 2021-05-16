package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0131PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> output = new ArrayList<List<String>>();
		dfs(0, s, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(int index, String s, List<String> list, List<List<String>> output) {
		if (index == s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (isPalindrome(str)) {
				list.add(str);
				dfs(i + 1, s, list, output);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equals(str);
	}

}
