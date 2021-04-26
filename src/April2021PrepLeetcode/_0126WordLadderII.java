package April2021PrepLeetcode;

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
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Integer> distMap = new HashMap<String, Integer>();
		HashSet<String> wordDict = new HashSet<String>(wordList);

		if (!wordDict.contains(endWord))
			return new ArrayList<List<String>>();

		bfs(beginWord, endWord, map, distMap, wordDict);
		List<List<String>> output = new ArrayList<List<String>>();
		dfs(beginWord, endWord, map, distMap, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, List<String>> map,
			HashMap<String, Integer> distMap, List<String> list, List<List<String>> output) {

		list.add(beginWord);
		if (beginWord.equals(endWord)) {
			output.add(new ArrayList<String>(list));
			list.remove(list.size() - 1);
			return;
		}

		if (map.containsKey(beginWord)) {
			List<String> neighbors = map.get(beginWord);
			for (String str : neighbors) {
				if (distMap.get(str) == distMap.get(beginWord) + 1) {
					dfs(str, endWord, map, distMap, list, output);
				}
			}
		}

		list.remove(list.size() - 1);
	}

	public static void bfs(String beginWord, String endWord, HashMap<String, List<String>> map,
			HashMap<String, Integer> distMap, HashSet<String> wordDict) {
		Queue<String> q = new LinkedList<String>();
		distMap.put(beginWord, 0);
		q.offer(beginWord);
		boolean endFound = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int currDistance = distMap.get(str);

				List<String> neighbors = getNeighbors(str, wordDict);
				for (String neighbor : neighbors) {
					if (!map.containsKey(str)) {
						map.put(str, new ArrayList<String>());
					}
					map.get(str).add(neighbor);

					if (!distMap.containsKey(neighbor)) {
						distMap.put(neighbor, currDistance + 1);
						if (neighbor.equals(endWord)) {
							endFound = true;
						} else {
							q.offer(neighbor);
						}
					}
				}
				if (endFound)
					break;
			}

		}
	}

	public static List<String> getNeighbors(String str, HashSet<String> wordDict) {
		List<String> output = new ArrayList<String>();
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != originalChar) {
					cArr[i] = c;
					String newString = new String(cArr);
					if (wordDict.contains(newString)) {
						output.add(newString);
					}
				}
			}
			cArr[i] = originalChar;
		}
		return output;
	}

}
