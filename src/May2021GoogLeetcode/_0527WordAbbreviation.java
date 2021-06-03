package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0527WordAbbreviation {

	public static void main(String[] args) {
		System.out.println(wordsAbbreviation(new ArrayList<String>(Arrays.asList("like", "god", "internal", "me",
				"internet", "interval", "intension", "face", "intrusion"))));
		System.out.println(wordsAbbreviation(new ArrayList<String>(Arrays.asList("aa", "aaa"))));
	}

	public static List<String> wordsAbbreviation(List<String> words) {
		int[] prefix = new int[words.size()];
		String[] ans = new String[words.size()];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = getAbbr(prefix[i], words.get(i));
		}

		HashSet<Integer> dupIndex = new HashSet<Integer>();
		for (int i = 0; i < ans.length; i++) {
			while (true) {
				dupIndex = new HashSet<Integer>();
				for (int j = i + 1; j < ans.length; j++) {
					if (ans[i].equals(ans[j])) {
						dupIndex.add(j);
					}
				}
				if (dupIndex.isEmpty())
					break;
				dupIndex.add(i);
				for (int index : dupIndex) {
					ans[index] = getAbbr(prefix[index]++, words.get(index));
				}
			}
		}
		return new ArrayList<String>(Arrays.asList(ans));
	}

	public static String getAbbr(int index, String word) {
		if (word.length() - index <= 3)
			return word;
		return word.substring(0, index + 1) + (word.length() - index - 2) + word.charAt(word.length() - 1);
	}

}
