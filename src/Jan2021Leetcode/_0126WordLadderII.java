package Jan2021Leetcode;

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
		String currString;
		HashSet<String> set;
		List<String> path;

		public Pair(String currString, HashSet<String> set, List<String> path) {
			this.currString = currString;
			this.set = set;
			this.path = path;
		}
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> set = new HashSet<String>(wordList);
		if (!set.contains(endWord))
			return output;

		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(beginWord, set, new ArrayList<String>(Arrays.asList(beginWord))));
		int count = 1;
		int minCount = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				String str = pair.currString;

				if (count > minCount)
					continue;
				if (str.equals(endWord)) {
					minCount = count;
					output.add(pair.path);
					continue;
				}

				char[] cArr = str.toCharArray();
				for (int j = 0; j < cArr.length; j++) {
					char currChar = cArr[j];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c != currChar) {
							cArr[j] = c;
							String strNew = new String(cArr);
							if (pair.set.contains(strNew)) {
								HashSet<String> newSet = (HashSet<String>) pair.set.clone();
								newSet.remove(strNew);
								List<String> list = new ArrayList<String>(pair.path);
								list.add(strNew);
								q.offer(new Pair(strNew, newSet, list));
							}
						}
					}
					cArr[j] = currChar;
				}
			}
			count++;
		}
		return output;
	}

}
