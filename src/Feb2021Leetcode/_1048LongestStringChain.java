package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class _1048LongestStringChain {

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
		System.out.println(longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));
		System.out.println(longestStrChain(new String[] { "bdca", "bda", "ca", "dca", "a" }));
	}

	public static int longestStrChain(String[] words) {
		List<String> list = new ArrayList<String>(Arrays.asList(words));
		HashSet<String> wordSet = new HashSet<String>(list);

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		int maxLength = 0;
		HashSet<String> visited = new HashSet<String>();
		for (int i = list.size() - 1; i >= 0; i--) {
			String str = list.get(i);
			if (!visited.contains(str)) {
				maxLength = Math.max(maxLength, 1 + getMaxLength(str, wordSet, visited));
			}
		}
		return maxLength;
	}

	public static int getMaxLength(String currWord, HashSet<String> wordSet, HashSet<String> visited) {
		int maxLength = 0;
		visited.add(currWord);
		for (int i = 0; i < currWord.length(); i++) {
			String newString = currWord.substring(0, i) + currWord.substring(i + 1);
			if (!visited.contains(newString) && wordSet.contains(newString)) {
				maxLength = Math.max(maxLength, 1 + getMaxLength(newString, wordSet, visited));
			}
		}
		return maxLength;
	}

}
