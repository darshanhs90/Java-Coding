package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0132PalindromePartitioningII {

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
	}

	public static int minCut(String s) {
		List<List<String>> output = partition(s);
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < output.size(); i++) {
			minLength = Math.min(minLength, output.get(i).size());
		}
		return minLength - 1;
	}

	public static void partition(int index, String s, List<String> list, List<List<String>> output) {
		if (index == s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		if (index >= s.length())
			return;

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (isPalindrome(str)) {
				list.add(str);
				partition(i + 1, s, list, output);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static List<List<String>> partition(String s) {
		List<List<String>> output = new ArrayList<List<String>>();
		HashMap<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
		HashMap<String, Boolean> palindromeMap = new HashMap<String, Boolean>();
		dfs(0, s, map, new ArrayList<String>(), output, palindromeMap);
		// return map.get(s);
		return output;
	}

	public static void dfs(int index, String s, HashMap<String, List<List<String>>> map, List<String> list,
			List<List<String>> output, HashMap<String, Boolean> palindromeMap) {
		if (index == s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			if (isPalindrome(sub, palindromeMap)) {
				list.add(sub);
				dfs(i + 1, s, map, list, output, palindromeMap);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s, HashMap<String, Boolean> palindromeMap) {
		if (palindromeMap.containsKey(s))
			return palindromeMap.get(s);

		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	

}
