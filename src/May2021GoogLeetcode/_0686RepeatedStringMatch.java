package May2021GoogLeetcode;

public class _0686RepeatedStringMatch {

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
		System.out.println(repeatedStringMatch("a", "aa"));
		System.out.println(repeatedStringMatch("a", "a"));
		System.out.println(repeatedStringMatch("abc", "wxyz"));
	}

	public static int repeatedStringMatch(String a, String b) {
		StringBuilder sb = new StringBuilder(a);

		int count = 1;
		while (sb.length() < b.length()) {
			sb.append(a);
			count++;
		}

		if (sb.toString().contains(b))
			return count;
		if (sb.append(a).toString().contains(b))
			return count + 1;
		return -1;
	}

}
