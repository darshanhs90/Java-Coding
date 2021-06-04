package June2021GoogLeetcode;

public class _0686RepeatedStringMatch {

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
		System.out.println(repeatedStringMatch("a", "aa"));
		System.out.println(repeatedStringMatch("a", "a"));
		System.out.println(repeatedStringMatch("abc", "wxyz"));
	}

	public static int repeatedStringMatch(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (sb.length() < b.length()) {
			sb.append(a);
			count += 1;
		}

		if (sb.toString().indexOf(b) != -1)
			return count;

		if (sb.append(a).toString().indexOf(b) != -1)
			return count + 1;
		return -1;
	}

}
