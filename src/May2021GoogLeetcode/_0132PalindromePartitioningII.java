package May2021GoogLeetcode;

public class _0132PalindromePartitioningII {

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
	}

	static int minCut;

	public static int minCut(String s) {
		if (s == null || s.length() < 2)
			return 0;
		minCut = Integer.MAX_VALUE;

		dfs(0, s, -1);
		return minCut;
	}

	public static void dfs(int index, String s, int cuts) {
		if (index == s.length()) {
			minCut = Math.min(minCut, cuts);
			return;
		}
		String str = "";
		for (int i = index; i < s.length(); i++) {
			str += s.charAt(i);
			if (isPalindrome(str)) {
				dfs(i + 1, s, cuts + 1);
			}
		}

	}

	public static boolean isPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equals(str);
	}

}
