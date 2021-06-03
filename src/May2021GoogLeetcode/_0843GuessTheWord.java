package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0843GuessTheWord {
	public static void main(String[] args) {
	}

	interface Master {
		public int guess(String word);
	}

	public void findSecretWord(String[] wordlist, Master master) {
		int noOfGuesses = 0;
		int matches = 0;
		List<String> list = new ArrayList<String>(Arrays.asList(wordlist));
		while (list.size() > 0 && matches != 6 && noOfGuesses < 10) {
			String currWord = list.remove(0);
			matches = master.guess(currWord);
			list = filterWords(matches, list, currWord);
			noOfGuesses++;
		}
	}

	public List<String> filterWords(int matches, List<String> list, String currWord) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			int currMatches = 0;
			String str = list.get(i);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == currWord.charAt(j))
					currMatches++;
			}

			if (currMatches == matches) {
				newList.add(str);
			}
		}
		return newList;
	}
}
