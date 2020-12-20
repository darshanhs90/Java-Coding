package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _023WordLadderII {

	public static void main(String[] args) {
		System.out.println(findLadders("hit", "cog",
				new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

		System.out.println(
				findLadders("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

		System.out.println(findLadders("red", "tax",
				new ArrayList<String>(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))));

	}

	static class Pair {
		String word;
		List<String> list;
		Set<String> dict;

		public Pair(String word, List<String> list, Set<String> dict) {
			this.word = word;
			this.list = list;
			this.dict = dict;
		}
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordDictionary = new HashSet<String>(wordList);
		List<List<String>> output = new ArrayList<List<String>>();
		if (!wordDictionary.contains(endWord))
			return output;
		int level = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		List<String> list = new ArrayList<String>();
		list.add(beginWord);
		Pair newPair = new Pair(beginWord, list, new HashSet<String>(wordDictionary));
		q.offer(newPair);
		int length = wordList.size();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				char charArr[] = pair.word.toCharArray();
				Set<String> dict = pair.dict;
				for (int j = 0; j < charArr.length; j++) {
					char originalChar = charArr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != originalChar) {
							charArr[j] = c;
							String newString = new String(charArr);
							if (newString.equals(endWord)) {
								pair.list.add(endWord);
								output.add(pair.list);
								length = Math.min(level, length);
							} else if (dict.contains(newString)) {
								List<String> newList = new ArrayList<String>(pair.list);
								newList.add(newString);
								Set<String> copy = new HashSet<String>(dict);
								copy.remove(newString);
								q.offer(new Pair(newString, newList, copy));
							}
						}
					}
					charArr[j] = originalChar;
				}

			}
			level++;
		}

		List<List<String>> out = new ArrayList<List<String>>();
		for (List<String> listNew : output) {
			if (listNew.size() == length + 1)
				out.add(listNew);
		}

		return out;
	}

}
