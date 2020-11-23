package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0131PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> output = new ArrayList<List<String>>();
		partition(0, s, new ArrayList<String>(), new HashSet<String>(), output);
		return output;
	}

	public static void partition(int startIndex, String s, List<String> list, HashSet<String> set,
			List<List<String>> output) {
		if (startIndex >= s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String subString = s.substring(startIndex, i + 1);
			if (isPalindrome(subString, set)) {
				set.add(subString);
				list.add(subString);
				partition(i + 1, s, list, set, output);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s, HashSet<String> set) {
		if (set.contains(s))
			return true;

		int leftIndex = 0, rightIndex = s.length() - 1;
		while (leftIndex < rightIndex) {
			if (s.charAt(leftIndex) != s.charAt(rightIndex))
				return false;
			leftIndex++;
			rightIndex--;
		}
		return true;
	}
}
