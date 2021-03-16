package Feb2021Leetcode;

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
		StringBuilder sb = new StringBuilder();
		if (strs == null || strs.length == 0)
			return "";
		int possibleMinLen = strs[0].length();
		for (int i = 0; i < possibleMinLen; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || strs[j].charAt(i) != c)
					return sb.toString();
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
