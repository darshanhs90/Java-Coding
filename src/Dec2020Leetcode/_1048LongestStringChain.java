package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class _1048LongestStringChain {

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
		System.out.println(longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));
		System.out.println(longestStrChain(new String[] { "bdca", "bda", "ca", "dca", "a" }));
	}

	public static int longestStrChain(String[] words) {
		HashSet<String> stringSet = new HashSet<String>();
		for (String s : words) {
			stringSet.add(s);
		}

		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		int maxLength = 1;
		HashMap<String, Integer> maxLengthMap = new HashMap<String, Integer>();
		for (int i = words.length - 1; i >= 0; i--) {
			maxLength = Math.max(maxLength, getMaxLength(words[i], maxLengthMap, stringSet));
		}

		return maxLength;
	}

	public static int getMaxLength(String word, HashMap<String, Integer> maxLengthMap, HashSet<String> stringSet) {
		if (maxLengthMap.containsKey(word))
			return maxLengthMap.get(word);

		int count = 1;
		int out = 0;
		for (int i = 0; i < word.length(); i++) {
			String subString = word.substring(0, i) + word.substring(i + 1);
			if (stringSet.contains(subString)) {
				out = Math.max(out, getMaxLength(subString, maxLengthMap, stringSet));
			}
		}
		if (out != Integer.MAX_VALUE)
			count += out;
		maxLengthMap.put(word, count);
		return count;
	}

}
