package June2021GoogLeetcode;

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
		HashMap<String, HashSet<String>> adjMap = new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> distMap = new HashMap<String, Integer>();
		List<List<String>> output = new ArrayList<List<String>>();
		for (int i = 0; i < wordList.size(); i++) {
			adjMap.put(wordList.get(i), new HashSet<String>());
		}
		bfs(beginWord, endWord, new HashSet<String>(wordList), adjMap, distMap);
		dfs(beginWord, endWord, adjMap, distMap, new ArrayList<String>(), output);
		return output;
	}

	public static List<String> getNeighbors(String str, HashSet<String> set) {
		char[] cArr = str.toCharArray();
		HashSet<String> list = new HashSet<String>();
		for (int i = 0; i < cArr.length; i++) {
			char orig = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != orig) {
					cArr[i] = c;
					String newString = new String(cArr);
					if (set.contains(newString)) {
						list.add(newString);
					}
				}
			}
			cArr[i] = orig;
		}
		return new ArrayList<String>(list);
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, HashSet<String>> adjMap,
			HashMap<String, Integer> distMap, List<String> list, List<List<String>> output) {
		list.add(beginWord);
		if (beginWord.equals(endWord)) {
			output.add(new ArrayList<String>(list));
		} else {
			Iterator<String> iter = adjMap.get(beginWord).iterator();
			while (iter.hasNext()) {
				String newStr = iter.next();
				if (distMap.get(newStr) == distMap.get(beginWord) + 1) {
					dfs(newStr, endWord, adjMap, distMap, list, output);
				}
			}
		}
		list.remove(list.size() - 1);
	}

	public static void bfs(String beginWord, String endWord, HashSet<String> wordSet,
			HashMap<String, HashSet<String>> adjMap, HashMap<String, Integer> distMap) {

		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		adjMap.put(beginWord, new HashSet<String>());
		distMap.put(beginWord, 0);
		boolean endFound = false;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int baseDist = distMap.get(str);

				List<String> neighbors = getNeighbors(str, wordSet);
				for (String newStr : neighbors) {
					if (newStr.equals(endWord)) {

						adjMap.get(str).add(newStr);
						distMap.put(newStr, baseDist + 1);
						endFound = true;
					} else {
						if (!distMap.containsKey(newStr)) {
							q.offer(newStr);
							adjMap.get(str).add(newStr);
							distMap.put(newStr, baseDist + 1);
						}
					}
				}
			}
			if (endFound)
				break;
		}
	}

}
