package June2021GoogLeetcode;

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
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;
		HashSet<String> set = new HashSet<String>(wordDict);
		for (int i = 1; i < dp.length; i++) {
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
