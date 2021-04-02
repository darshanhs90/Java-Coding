package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0151ReverseWordsInAString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  Bob    Loves  Alice   "));
		System.out.println(reverseWords("Alice does not even like bob"));
	}

	public static String reverseWords(String s) {
		String[] str = s.split(" ");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			String strn = str[i].trim();
			if (strn.length() > 0)
				list.add(strn);
		}
		Collections.reverse(list);
		return String.join(" ", list);
	}
}
