package May2021GoogLeetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		for (String str : wordList) {
			map.put(str, new ArrayList<String>());
		}
		bfs(beginWord, endWord, map, distMap, new HashSet<String>(wordList));
		dfs(beginWord, endWord, map, distMap, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, List<String>> map,
			HashMap<String, Integer> distMap, List<String> list, List<List<String>> output) {
		list.add(beginWord);

		if (beginWord.equals(endWord)) {
			output.add(new ArrayList<String>(list));
		} else {
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
			HashMap<String, Integer> distMap, HashSet<String> set) {
		Queue<String> q = new LinkedList<String>();
		boolean endFound = false;
		q.offer(beginWord);
		distMap.put(beginWord, 0);
		map.put(beginWord, new ArrayList<String>());
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int currDist = distMap.get(str);

				List<String> neighbors = getNeighbors(str, set);
				for (String strNew : neighbors) {
					if (strNew.equals(endWord)) {
						endFound = true;
						map.get(str).add(strNew);
						distMap.put(strNew, currDist + 1);
					} else {
						if (!distMap.containsKey(strNew)) {
							q.offer(strNew);
							map.get(str).add(strNew);
							distMap.put(strNew, currDist + 1);
						}
					}
				}
			}

			if (endFound)
				break;
		}
	}

	public static List<String> getNeighbors(String str, HashSet<String> set) {
		char[] cArr = str.toCharArray();
		HashSet<String> out = new HashSet<String>();
		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != originalChar) {
					cArr[i] = c;
					String newStr = new String(cArr);
					if (set.contains(newStr)) {
						out.add(newStr);
					}
				}
			}
			cArr[i] = originalChar;
		}

		return new ArrayList<String>(out);
	}

}
