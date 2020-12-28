package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0139WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))));
		System.out.println(wordBreak("applepenapple", new ArrayList<String>(Arrays.asList("apple", "pen"))));
		System.out.println(
				wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i <= len; i++) {
				String subString = s.substring(i, len);
				if (dp[i] && set.contains(subString)) {
					dp[len] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
