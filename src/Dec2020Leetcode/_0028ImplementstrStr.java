package Dec2020Leetcode;

public class _0028ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("a", "a"));
		System.out.println(strStr("mississippi", "issipi"));
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		else if ((haystack.length() == 0) || (needle.length() > haystack.length()))
			return -1;

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int index = 0;
				for (index = 0; index < needle.length() && i + index < haystack.length(); index++) {
					if (haystack.charAt(i + index) != needle.charAt(index)) {
						break;
					}
				}
				if (index == needle.length())
					return i;
			}
		}
		return -1;
	}

}
