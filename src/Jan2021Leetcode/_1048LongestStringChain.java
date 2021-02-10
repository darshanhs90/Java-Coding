package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class _1048LongestStringChain {

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
		System.out.println(longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));
		System.out.println(longestStrChain(new String[] { "bdca", "bda", "ca", "dca", "a" }));
	}

	static int maxLength;

	public static int longestStrChain(String[] words) {
		maxLength = 0;
		if (words == null || words.length == 0)
			return 0;
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length() - o1.length();
			}
		});

		HashSet<String> set = new HashSet<String>(new ArrayList<String>(Arrays.asList(words)));
		for (int i = words.length - 1; i >= 0; i--) {
			dfs(words[i], set, 1);
		}
		return maxLength;
	}

	public static void dfs(String word, HashSet<String> set, int len) {
		maxLength = Math.max(len, maxLength);

		for (int i = 0; i < word.length(); i++) {
			String subStr = word.substring(0, i) + word.substring(i + 1);
			if (set.contains(subStr)) {
				dfs(subStr, set, len + 1);
			}
		}
	}

}
