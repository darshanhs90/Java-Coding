package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	public static void main(String[] args) {
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("un", "iq", "ue"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("cha", "r", "act", "ers"))));
		System.out.println(maxLength(new ArrayList<String>(Arrays.asList("abcdefghijklmnopqrstuvwxyz"))));
	}

	static int maxCount = 0;

	public static int maxLength(List<String> arr) {
		maxCount = 0;
		dfs(0, 0, new HashSet<Character>(), new HashSet<Integer>(), arr);
		return maxCount;
	}

	public static void dfs(int index, int currCount, HashSet<Character> visited, HashSet<Integer> visitedIndex,
			List<String> arr) {
		maxCount = Math.max(currCount, maxCount);
		if (index >= arr.size())
			return;
		for (int i = index; i < arr.size(); i++) {
			String str = arr.get(i);
			if (!overLaps(visited, str)) {
				addToSet(visited, str);
				dfs(i + 1, currCount + str.length(), visited, visitedIndex, arr);
				removeFromSet(visited, str);
			}
		}
	}

	public static void addToSet(HashSet<Character> visited, String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			visited.add(c);
		}
	}

	public static void removeFromSet(HashSet<Character> visited, String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			visited.remove(c);
		}
	}

	public static boolean overLaps(HashSet<Character> visited, String str) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (visited.contains(c) || set.contains(c))
				return true;
			set.add(c);
		}
		return false;
	}

}
