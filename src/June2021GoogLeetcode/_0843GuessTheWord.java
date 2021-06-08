package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0843GuessTheWord {
	public static void main(String[] args) {
	}

	interface Master {
		public int guess(String word);
	}

	public void findSecretWord(String[] wordList, Master master) {
		List<String> list = new ArrayList<String>();
		list.add(wordList[0]);
		for (int i = 0; i < 10; i++) {
			String str = list.remove(0);
			int matches = master.guess(str);
			if (matches == 6)
				return;
			populateList(matches, wordList, str, list);
		}
	}

	public void populateList(int matches, String[] wordlist, String baseString, List<String> list) {
		for (int i = 0; i < wordlist.length; i++) {
			String str = wordlist[i];
			if (str.equals(baseString))
				continue;
			int comparisonMatch = 0;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == baseString.charAt(j))
					comparisonMatch++;
			}

			if (matches == 0) {
				list.add(str);
			} else {
				if (matches == comparisonMatch)
					list.add(str);
			}
		}
	}
}
