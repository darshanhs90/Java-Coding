package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0126WordLadderII {

	public static void main(String[] args) {
		System.out.println(findLadders("hit", "cog",
				new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

		System.out.println(
				findLadders("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
	}

	static class Pair {
		List<String> list;
		String currWord;

		public Pair(String currWord) {
			this.currWord = currWord;
			this.list = new ArrayList<String>();
		}
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> wordSet = new HashSet<String>(wordList);
		if (!wordSet.contains(endWord)) {
			return output;
		}

		Queue<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair(beginWord);
		p.list.add(beginWord);
		q.offer(p);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				p = q.poll();
				if (p.currWord.equals(endWord)) {
					if (output.size() == 0 || output.get(0).size() > p.list.size()) {
						output.clear();
						output.add(p.list);
					} else {
						if (output.get(0).size() == p.list.size()) {
							output.add(p.list);
						}
					}

					break;
				}

				String currWord = p.currWord;
				char[] cArr = currWord.toCharArray();

				for (int j = 0; j < cArr.length; j++) {
					char originalChar = cArr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != originalChar) {
							cArr[j] = c;
							String newString = new String(cArr);
							if (!p.list.contains(newString) && wordSet.contains(newString)) {
								Pair newPair = new Pair(newString);
								newPair.list.addAll(p.list);
								newPair.list.add(newString);
								q.offer(newPair);
							}
						}
						cArr[j] = originalChar;
					}
				}
			}
		}
		return output;
	}

}
