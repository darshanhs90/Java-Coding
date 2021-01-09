package Dec2020Leetcode;

public class _0796RotateString {
	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}

	public static boolean rotateString(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
	}

}
