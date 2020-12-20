package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _031WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))));
		System.out.println(wordBreak("applepenapple", new ArrayList<String>(Arrays.asList("apple", "pen"))));
		System.out.println(
				wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return true;
		Set<String> set = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int len = 1; len < dp.length; len++) {
			for (int i = 0; i < len; i++) {
				String str = s.substring(i, len);
				if (dp[i] && set.contains(str)) {
					dp[len] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}

}
