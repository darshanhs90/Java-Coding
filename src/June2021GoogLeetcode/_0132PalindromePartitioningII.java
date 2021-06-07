package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0132PalindromePartitioningII {

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
	}

	static int minCuts;

	public static int minCut(String s) {
		minCuts = Integer.MAX_VALUE;
		dfs(0, s, new ArrayList<String>());
		return minCuts - 1;
	}

	public static void dfs(int index, String s, List<String> list) {
		if (index == s.length()) {
			minCuts = Math.min(minCuts, list.size());
			return;
		}

		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (isPalindrome(str)) {
				list.add(str);
				dfs(i + 1, s, list);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equals(str);
	}

}
