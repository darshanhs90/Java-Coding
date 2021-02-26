package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0139WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))));
		System.out.println(wordBreak("applepenapple", new ArrayList<String>(Arrays.asList("apple", "pen"))));
		System.out.println(
				wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
		System.out.println(wordBreak("a", new ArrayList<String>(Arrays.asList("a"))));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return false;

		HashSet<String> set = new HashSet<String>(wordDict);
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				String str = s.substring(j, i);
				if (dp[j] && set.contains(str)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
