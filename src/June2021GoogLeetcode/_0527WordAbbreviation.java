package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0527WordAbbreviation {

	public static void main(String[] args) {
		System.out.println(wordsAbbreviation(new ArrayList<String>(Arrays.asList("like", "god", "internal", "me",
				"internet", "interval", "intension", "face", "intrusion"))));
		System.out.println(wordsAbbreviation(new ArrayList<String>(Arrays.asList("aa", "aaa"))));
	}

	public static List<String> wordsAbbreviation(List<String> words) {
		int[] prefixArr = new int[words.size()];
		String[] str = new String[words.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = getAbbr(prefixArr[i], words.get(i));
		}

		for (int i = 0; i < str.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			while (true) {
				set = new HashSet<Integer>();
				for (int j = i + 1; j < str.length; j++) {
					if (str[i].equals(str[j])) {
						set.add(j);
					}
				}

				if (set.isEmpty())
					break;

				set.add(i);
				Iterator<Integer> iter = set.iterator();
				while (iter.hasNext()) {
					int val = iter.next();
					str[val] = getAbbr(prefixArr[val]++, words.get(val));
				}
			}
		}

		return new ArrayList<String>(Arrays.asList(str));
	}

	public static String getAbbr(int index, String word) {
		if (word.length() - index <= 3)
			return word;
		return word.substring(0, index + 1) + (word.length() - index - 2) + word.charAt(word.length() - 1);
	}

}
