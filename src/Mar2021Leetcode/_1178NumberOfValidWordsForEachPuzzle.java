package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _1178NumberOfValidWordsForEachPuzzle {

	public static void main(String[] args) {
		System.out.println(
				findNumOfValidWords(new String[] { "aaaa", "asas", "able", "ability", "actt", "actor", "access" },
						new String[] { "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz" }));
	}

	public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		HashSet[] wordsSet = new HashSet[words.length];
		HashSet[] puzzlesSet = new HashSet[puzzles.length];

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			wordsSet[i] = new HashSet<Character>();
			for (int j = 0; j < word.length(); j++) {
				wordsSet[i].add(word.charAt(j));
			}
		}
		for (int i = 0; i < puzzles.length; i++) {
			String puzzle = puzzles[i];
			puzzlesSet[i] = new HashSet<Character>();
			for (int j = 0; j < puzzle.length(); j++) {
				puzzlesSet[i].add(puzzle.charAt(j));
			}
		}

		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < puzzles.length; i++) {
			int count = 0;
			for (int j = 0; j < words.length; j++) {
				if (wordsSet[j].contains(puzzles[i].charAt(0))) {
					if (match(wordsSet[j], puzzlesSet[i]))
						count++;
				}
			}
			output.add(count);
		}
		return output;
	}

	public static boolean match(HashSet<Character> wordsSet, HashSet<Character> puzzlesSet) {
		Iterator<Character> iter = wordsSet.iterator();
		while (iter.hasNext()) {
			if (!puzzlesSet.contains(iter.next()))
				return false;
		}
		return true;
	}
}
