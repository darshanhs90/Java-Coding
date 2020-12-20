package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _034WordLadder {

	public static void main(String[] args) {
		System.out.println(ladderLength("a", "c", new ArrayList<String>(Arrays.asList("a", "b", "c"))));
		System.out.println("********");
		System.out.println(ladderLength("hit", "cog",
				new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
		System.out.println("********");
		System.out.println(
				ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

		System.out.println("********");
		System.out.println(ladderLength("qa", "sq",
				new ArrayList<String>(Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr",
						"ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow",
						"sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt",
						"lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha",
						"hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
						"er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa",
						"he", "lr", "sq", "ye"))));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> wordDict = new HashSet<String>(wordList);
		if (!wordDict.contains(endWord))
			return 0;
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<>();
		queue.add(beginWord);
		visited.add(beginWord);

		int currLevel = 0;
		while (!queue.isEmpty()) {
			int qSize = queue.size();

			for (int size = 0; size < qSize; size++) {
				String currString = queue.poll();
				if (currString.equals(endWord))
					return currLevel + 1;

				char[] strArray = currString.toCharArray();
				for (int i = 0; i < strArray.length; i++) {
					char currChar = strArray[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != currChar) {
							strArray[i] = c;
							String newString = new String(strArray);

							if (wordDict.contains(newString) && !visited.contains(newString)) {
								queue.add(newString);
								visited.add(newString);
							}
						}
					}
					strArray[i] = currChar;
				}
			}
			currLevel++;
		}
		return 0;
	}
}
