package May2021GoogLeetcode;

import java.util.HashMap;

public class _0833FindAndReplaceInString {
	public static void main(String[] args) {
		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
				new String[] { "eee", "ffff" }));

		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
				new String[] { "eee", "ffff" }));
	}

	public static String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < targets.length; i++) {
			if (s.startsWith(sources[i], indexes[i])) {
				map.put(indexes[i], i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(i)) {
				sb.append(targets[map.get(i)]);
				i += sources[map.get(i)].length() - 1;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
