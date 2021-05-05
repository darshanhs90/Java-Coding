package May2021PrepLeetcode;

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
		HashSet<String> wordSet = new HashSet<String>(wordList);
		if (!wordSet.contains(endWord))
			return output;
		HashMap<String, List<String>> wordMap = new HashMap<String, List<String>>();
		HashMap<String, Integer> distMap = new HashMap<String, Integer>();
		bfs(beginWord, endWord, wordMap, distMap, wordSet);
		dfs(beginWord, endWord, wordMap, distMap, new ArrayList<String>(), output);
		return output;
	}

	public static void dfs(String beginWord, String endWord, HashMap<String, List<String>> wordMap,
			HashMap<String, Integer> distMap, List<String> list, List<List<String>> output) {
		list.add(beginWord);

		if (beginWord.equals(endWord)) {
			output.add(new ArrayList<String>(list));
		} else {
			List<String> neighbors = wordMap.get(beginWord);
			int currDist = distMap.get(beginWord);
			for (String str : neighbors) {
				if (distMap.get(str) == currDist + 1) {
					dfs(str, endWord, wordMap, distMap, list, output);
				}
			}
		}
		list.remove(list.size() - 1);
	}

	public static void bfs(String beginWord, String endWord, HashMap<String, List<String>> wordMap,
			HashMap<String, Integer> distMap, HashSet<String> wordSet) {
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		Iterator<String> iter = wordSet.iterator();
		while (iter.hasNext()) {
			wordMap.put(iter.next(), new ArrayList<String>());
		}
		wordMap.put(beginWord, new ArrayList<String>());
		distMap.put(beginWord, 0);
		boolean hasFound = false;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				int currDist = distMap.get(str);
				List<String> neighbors = getNeighbors(str, wordSet);
				for (String newStr : neighbors) {
					if (newStr.equals(endWord)) {
						hasFound = true;
						wordMap.get(str).add(newStr);
						distMap.put(newStr, currDist + 1);
					} else {
						if (!distMap.containsKey(newStr)) {
							q.offer(newStr);
							wordMap.get(str).add(newStr);
							distMap.put(newStr, currDist + 1);
						}
					}
				}
			}
			if (hasFound)
				return;
		}
	}

	public static List<String> getNeighbors(String str, HashSet<String> wordSet) {
		HashSet<String> set = new HashSet<String>();
		char[] cArr = str.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			char originalChar = cArr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != originalChar) {
					cArr[i] = c;
					String newString = new String(cArr);
					if (wordSet.contains(newString)) {
						set.add(newString);
					}
				}
			}
			cArr[i] = originalChar;
		}
		return new ArrayList<String>(set);
	}

}
