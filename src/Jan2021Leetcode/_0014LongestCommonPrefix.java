package Jan2021Leetcode;

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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				String str = strs[j];
				if (i < str.length()) {
					if (str.charAt(i) != c)
						return sb.toString();
				} else {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
