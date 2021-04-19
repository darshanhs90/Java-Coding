package April2021PrepLeetcode;

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

		HashSet[] puzzleSet = new HashSet[puzzles.length];
		HashSet[] wordsSet = new HashSet[words.length];
		for (int i = 0; i < puzzleSet.length; i++) {
			puzzleSet[i] = new HashSet<Character>();
			String puzzle = puzzles[i];
			for (int j = 0; j < puzzle.length(); j++) {
				puzzleSet[i].add(puzzle.charAt(j));
			}
		}

		for (int i = 0; i < words.length; i++) {
			wordsSet[i] = new HashSet<Character>();
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				wordsSet[i].add(word.charAt(j));
			}
		}

		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < puzzles.length; i++) {
			int count = 0;
			HashSet<Character> currPuzzleSet = puzzleSet[i];
			for (int j = 0; j < words.length; j++) {
				if (!wordsSet[j].contains(puzzles[i].charAt(0)))
					continue;
				if (setMatches(currPuzzleSet, wordsSet[j])) {
					count++;
				}
			}
			output.add(count);
		}
		return output;
	}

	public static boolean setMatches(HashSet<Character> currPuzzleSet, HashSet<Character> currWordSet) {
		Iterator<Character> iter = currWordSet.iterator();
		while (iter.hasNext()) {
			if (!currPuzzleSet.contains(iter.next()))
				return false;
		}
		return true;
	}
}
