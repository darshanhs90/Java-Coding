package May2021Leetcode;

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
		HashSet<String> set = new HashSet<String>(wordList);
		if (!set.contains(endWord))
			return output;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Integer> distMap = new HashMap<String, Integer>();
		bfs(beginWord, endWord, map, distMap, set);

		System.out.println(map);
		System.out.println(distMap);
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
		Iterator<String> iter = set.iterator();
		map.put(beginWord, new ArrayList<String>());
		while (iter.hasNext()) {
			map.put(iter.next(), new ArrayList<String>());
		}

		q.offer(beginWord);
		boolean endFound = false;
		distMap.put(beginWord, 0);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int currDist = distMap.get(str);
				List<String> neighbors = getNeighbors(str, set);
				for (String newStr : neighbors) {
					if (newStr.equals(endWord)) {
						endFound = true;
						map.get(str).add(newStr);
						distMap.put(newStr, currDist + 1);
					} else {
						if (!distMap.containsKey(newStr)) {
							q.offer(newStr);
							map.get(str).add(newStr);
							distMap.put(newStr, currDist + 1);
						}
					}
				}
			}
			if (endFound)
				return;
		}

	}

	public static List<String> getNeighbors(String str, HashSet<String> set) {
		HashSet<String> output = new HashSet<String>();
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char origChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != origChar) {
					cArr[i] = c;
					String newStr = new String(cArr);
					if (set.contains(newStr)) {
						output.add(newStr);
					}
				}
			}
			cArr[i] = origChar;
		}
		return new ArrayList<String>(output);
	}

}
