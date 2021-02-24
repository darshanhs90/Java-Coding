package Jan2021Leetcode;

import java.util.HashSet;

public class _0318MaximumProductOfWordLengths {

	public static void main(String[] args) {
		System.out.println(maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
	}

	public static int maxProduct(String[] words) {
		HashSet[] setArr = new HashSet[words.length];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			setArr[i] = new HashSet<Character>();
			for (int j = 0; j < word.length(); j++) {
				setArr[i].add(word.charAt(j));
			}
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			for (int j = i + 1; j < setArr.length; j++) {
				boolean overLaps = false;
				for (int j2 = 0; j2 < word.length(); j2++) {
					if (setArr[j].contains(word.charAt(j2))) {
						overLaps = true;
						break;
					}
				}
				if (!overLaps) {
					max = Math.max(max, word.length() * words[j].length());
				}
			}
		}
		return max;
	}

}
