package Jan2021Leetcode;

public class _0028ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("a", "a"));
		System.out.println(strStr("mississippi", "issipi"));
	}

	public static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

}
