package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0132PalindromePartitioningII {

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
	}

	static int minSplits = Integer.MAX_VALUE;

	public static int minCut(String s) {
		minSplits = Integer.MAX_VALUE;
		HashSet<String> palindromes = new HashSet<String>();
		partitionString(0, s, new ArrayList<String>(), palindromes);
		return minSplits;
	}

	public static void partitionString(int index, String s, List<String> list, HashSet<String> palindromes) {
		if (index == s.length()) {
			minSplits = Math.min(minSplits, list.size() - 1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (palindromes.contains(sb.toString()) || isPalindrome(sb.toString())) {
				palindromes.add(sb.toString());
				list.add(sb.toString());
				partitionString(i + 1, s, list, palindromes);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);
	}

}
