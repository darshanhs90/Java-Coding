package Nov2020Leetcode;

public class _0014LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefix(new String[] { "" }));
		System.out.println(longestCommonPrefix(new String[] { "a" }));
		System.out.println(longestCommonPrefix(new String[] { "ab", "a" }));
		System.out.println(longestCommonPrefix(new String[] { "flower", "flower", "flower", "flower" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];
		int index = 0;
		boolean exitLoop = false;
		StringBuilder sb = new StringBuilder();
		while (index < strs[0].length() && !exitLoop) {
			Character c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || c != strs[i].charAt(index)) {
					exitLoop = true;
					break;
				}
			}
			if (!exitLoop)
				sb = sb.append(c);
			index++;
		}
		return index > 0 ? sb.toString() : "";
	}
}
