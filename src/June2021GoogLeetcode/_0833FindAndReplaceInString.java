package June2021GoogLeetcode;

import java.util.TreeMap;

public class _0833FindAndReplaceInString {
	public static void main(String[] args) {
		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
				new String[] { "eee", "ffff" }));

		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
				new String[] { "eee", "ffff" }));
	}

	public static String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < indexes.length; i++) {
			int index = indexes[i];
			String str = sources[i];
			String subString = s.substring(index);

			if (subString.startsWith(str)) {
				map.put(index, i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(i)) {
				sb.append(s.charAt(i));
				continue;
			}

			sb.append(targets[map.get(i)]);
			i += sources[map.get(i)].length() - 1;
		}
		return sb.toString();
	}
}
