package Nov2020_GoogPrep;

import java.util.HashMap;
import java.util.Map;

public class _019FindAndReplaceInString {

	public static void main(String[] args) {
		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
				new String[] { "eee", "ffff" }));

		System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
				new String[] { "eee", "ffff" }));
	}

	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < S.length(); i++) {
			map.put(i, S.charAt(i) + "");
		}
		HashMap<Integer, String> mapCopy = (HashMap<Integer, String>) map.clone();
		for (int i = 0; i < indexes.length; i++) {
			int startIndex = indexes[i];
			String sourceString = sources[i];
			String targetString = targets[i];
			boolean isValid = true;
			for (int j = 0; j < sourceString.length(); j++) {
				if (!(sourceString.charAt(j) + "").equals(map.get(startIndex))) {
					isValid = false;
					break;
				}
				startIndex++;
			}

			if (isValid) {
				startIndex = indexes[i];
				for (int j = 0; j < sourceString.length(); j++) {
					mapCopy.put(startIndex, "");
					startIndex++;
				}
				mapCopy.put(indexes[i], targetString);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry : mapCopy.entrySet()) {
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
}
