package Leetcode2020Nov;

public class _0796RotateString {
	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}

	public static boolean rotateString(String A, String B) {
		for (int i = 0; i < A.length(); i++) {
			String newString = A.substring(i) + A.substring(0, i);
			if (newString.contentEquals(B))
				return true;
		}
		return A.contentEquals(B);
	}
}
