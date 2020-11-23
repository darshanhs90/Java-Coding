package Nov2020Leetcode;

public class _0028ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("a", "a"));
	}

	public static int strStr(String haystack, String needle) {
		if ((haystack == null && needle == null) || (haystack.length() == 0 && needle.length() == 0)
				|| needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		char needleChar = needle.charAt(0);
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needleChar && checkStringMatch(haystack, needle, i)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean checkStringMatch(String haystack, String needle, int index) {
		if (index + needle.length() > haystack.length())
			return false;
		for (int i = 0; i < needle.length(); i++) {
			if (haystack.charAt(index) == needle.charAt(i)) {
				index++;
			} else {
				return false;
			}
		}
		return true;
	}
}
