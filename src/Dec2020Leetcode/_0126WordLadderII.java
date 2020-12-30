package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
		String word;
		HashSet<String> set;
		List<String> list;

		public Pair(String word, HashSet<String> set, List<String> list) {
			this.word = word;
			this.set = set;
			this.list = list;
		}
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> set = new HashSet<String>(wordList);
		if (!set.contains(endWord))
			return output;
		int min = Integer.MAX_VALUE;
		HashMap<Integer, List<List<String>>> outMap = new HashMap<Integer, List<List<String>>>();
		int level = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		List<String> list = new ArrayList<String>();
		list.add(beginWord);
		q.offer(new Pair(beginWord, set, list));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				HashSet<String> pairSet = p.set;
				List<String> pairList = p.list;
				String word = p.word;
				char[] cArr = word.toCharArray();
				for (int j = 0; j < cArr.length; j++) {
					char originalChar = cArr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != originalChar) {
							cArr[j] = c;
							String newString = new String(cArr);
							if (newString.equals(endWord)) {
								pairList.add(newString);
								min = Math.min(min, level + 1);
								if (outMap.containsKey(level + 1)) {
									outMap.get(level + 1).add(new ArrayList<String>(pairList));
								} else {
									List<List<String>> outputTemp = new ArrayList<List<String>>();
									outputTemp.add(new ArrayList<String>(pairList));
									outMap.put(level + 1, outputTemp);
								}
								pairList.remove(pairList.size() - 1);
							}

							if (pairSet.contains(newString)) {
								HashSet<String> setClone = (HashSet<String>) pairSet.clone();
								setClone.remove(newString);
								pairList.add(newString);
								q.offer(new Pair(newString, setClone, new ArrayList<String>(pairList)));
								pairList.remove(pairList.size() - 1);
							}
						}
					}
					cArr[j] = originalChar;
				}
			}

			level++;
		}

		if (min == Integer.MIN_VALUE)
			return output;
		else
			return outMap.get(min);
	}

}
