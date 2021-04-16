package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		List<List<String>> output = new ArrayList<List<String>>();
		HashMap<String, List<String>> neighborsMap = new HashMap<String, List<String>>();
		HashMap<String, Integer> distanceMap = new HashMap<String, Integer>();
		HashSet<String> wordSet = new HashSet<String>(wordList);
		wordSet.add(beginWord);
		bfs(beginWord, endWord, neighborsMap, distanceMap, wordSet);
		dfs(beginWord, endWord, neighborsMap, distanceMap, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, List<String>> neighborsMap,
			HashMap<String, Integer> distanceMap, List<String> list, List<List<String>> output) {
		list.add(beginWord);

		if (beginWord.equals(endWord)) {
			output.add(new ArrayList<String>(list));
		} else {
			List<String> neighbors = neighborsMap.get(beginWord);
			for (String str : neighbors) {
				if (distanceMap.get(str) == distanceMap.get(beginWord) + 1) {
					dfs(str, endWord, neighborsMap, distanceMap, list, output);
				}
			}
		}
		list.remove(list.size() - 1);
	}

	public static void bfs(String beginWord, String endWord, HashMap<String, List<String>> neighborsMap,
			HashMap<String, Integer> distanceMap, HashSet<String> wordSet) {
		Iterator<String> iter = wordSet.iterator();
		while (iter.hasNext()) {
			neighborsMap.put(iter.next(), new ArrayList<String>());
		}

		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		distanceMap.put(beginWord, 0);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean endFound = false;
			for (int i = 0; i < size; i++) {
				String currString = q.poll();
				int currDistance = distanceMap.get(currString);

				List<String> neighbors = getNeighbors(currString, wordSet);

				for (String str : neighbors) {
					neighborsMap.get(currString).add(str);

					if (!distanceMap.containsKey(str)) {
						distanceMap.put(str, currDistance + 1);
						if (str.equals(endWord)) {
							endFound = true;
						} else {
							q.offer(str);
						}
					}

				}
				if (endFound)
					break;
			}

		}
	}

	public static List<String> getNeighbors(String str, HashSet<String> wordSet) {
		HashSet<String> out = new HashSet<String>();
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != originalChar) {
					cArr[i] = c;
					String newString = new String(cArr);
					if (wordSet.contains(newString)) {
						out.add(newString);
					}
				}
			}
			cArr[i] = originalChar;
		}
		return new ArrayList<String>(out);
	}

}
