package May2021PrepLeetcode;

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

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		HashMap<String, List<String>> wordMap = new HashMap<String, List<String>>();
		HashMap<String, Integer> distMap = new HashMap<String, Integer>();
		HashSet<String> wordSet = new HashSet<String>(wordList);
		List<List<String>> out = new ArrayList<List<String>>();
		if (!wordSet.contains(endWord))
			return out;
		for (String str : wordList) {
			wordMap.put(str, new ArrayList<String>());
		}

		bfs(beginWord, endWord, wordMap, distMap, wordSet);
		dfs(beginWord, endWord, wordMap, distMap, new ArrayList<String>(), out);
		return out;
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, List<String>> wordMap,
			HashMap<String, Integer> distMap, List<String> list, List<List<String>> out) {
		list.add(beginWord);

		if (beginWord.equals(endWord)) {
			out.add(new ArrayList<String>(list));
		} else {
			int dist = distMap.get(beginWord);
			List<String> neighbors = wordMap.get(beginWord);
			for (String str : neighbors) {
				if (distMap.get(str) == dist + 1) {
					dfs(str, endWord, wordMap, distMap, list, out);
				}
			}
		}
		list.remove(list.size() - 1);
	}

	public static void bfs(String beginWord, String endWord, HashMap<String, List<String>> wordMap,
			HashMap<String, Integer> distMap, HashSet<String> wordSet) {
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		wordMap.put(beginWord, new ArrayList<String>());
		distMap.put(beginWord, 0);

		boolean endFound = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int currDist = distMap.get(str);

				List<String> neighbors = getNeighbors(str, wordSet);
				for (String neighbor : neighbors) {
					if (neighbor.equals(endWord)) {
						wordMap.get(str).add(neighbor);
						distMap.put(neighbor, currDist + 1);
						endFound = true;
					} else {
						if (distMap.containsKey(neighbor)) {
							continue;
						}
						q.offer(neighbor);
						wordMap.get(str).add(neighbor);
						distMap.put(neighbor, currDist + 1);
					}
				}
			}
			if (endFound)
				return;
		}
	}

	public static List<String> getNeighbors(String beginWord, HashSet<String> wordSet) {
		char[] cArr = beginWord.toCharArray();
		HashSet<String> list = new HashSet<String>();
		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (originalChar == c) {
					continue;
				}
				cArr[i] = c;
				String newString = new String(cArr);
				if (wordSet.contains(newString)) {
					list.add(newString);
				}
			}
			cArr[i] = originalChar;
		}
		return new ArrayList<String>(list);
	}

}
