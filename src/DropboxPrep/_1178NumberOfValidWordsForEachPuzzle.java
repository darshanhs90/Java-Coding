package DropboxPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1178NumberOfValidWordsForEachPuzzle {

	public static void main(String[] args) {
		System.out.println(
				findNumOfValidWords(new String[] { "aaaa", "asas", "able", "ability", "actt", "actor", "access" },
						new String[] { "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz" }));
	}

	public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		HashSet[] setArr = new HashSet[puzzles.length];
		for (int i = 0; i < puzzles.length; i++) {
			setArr[i] = new HashSet<Character>();
			String puzzle = puzzles[i];
			for (int j = 0; j < puzzle.length(); j++) {
				setArr[i].add(puzzle.charAt(j));
			}
		}
		List<Integer> out = new ArrayList<Integer>();

		for (int j = 0; j < setArr.length; j++) {
			int count = 0;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				boolean matches = word.indexOf(puzzles[j].charAt(0)) > -1;
				for (int k = 0; k < word.length() && matches; k++) {
					char c = word.charAt(k);
					if (!setArr[j].contains(c)) {
						matches = false;
						break;
					}
				}
				if (matches) {
					count++;
				}
			}
			out.add(count);
		}
		return out;
	}
}
