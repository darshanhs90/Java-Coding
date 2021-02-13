package Jan2021Leetcode;

public class _0796RotateString {
	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}

	public static boolean rotateString(String A, String B) {
		if(A.length() != B.length())
			return false;
		return (A + A).indexOf(B) > -1;
	}

}
