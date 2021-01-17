package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0115DistinctSubsequences {

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
		System.out.println(numDistinct("babgbag", "bag"));
	}

	public static int numDistinct(String s, String t) {
		if (s.length() < t.length() || t.length() == 0)
			return 0;
		if (s.length() == t.length()) {
			if (s.equals(t))
				return 1;
			else
				return 0;
		}

		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.get(c).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(c, list);
			}
		}
		int count = 0;
		if (map.containsKey(t.charAt(0))) {
			List<Integer> list = map.get(t.charAt(0));
			for (Integer index : list) {
				count += dfs(index, map, t, 1);
			}
			return count;
		}
		return 0;
	}

	public static int dfs(int currCharIndex, HashMap<Character, List<Integer>> map, String t, int nextIndex) {
		if (nextIndex == t.length())
			return 1;
		if (nextIndex > t.length())
			return 0;
		int count = 0;
		char newChar = t.charAt(nextIndex);
		List<Integer> list = map.get(newChar);
		for (Integer index : list) {
			if (index > currCharIndex)
				count += dfs(index, map, t, nextIndex + 1);
		}

		return count;
	}

}
