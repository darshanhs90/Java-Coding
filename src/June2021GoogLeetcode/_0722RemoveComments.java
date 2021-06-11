package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0722RemoveComments {
	public static void main(String[] args) {
		System.out.println(removeComments(new String[] { "/*Test program */", "int main()", "{ ",
				"  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
				"   testing */", "a = b + c;", "}" }));

		System.out.println(removeComments(new String[] { "a/*comment", "line", "more_comment*/b" }));

	}

	public static List<String> removeComments(String[] source) {
		List<String> list = new ArrayList<String>();
		boolean blockComment = false;
		StringBuilder sb = new StringBuilder();
		for (String str : source) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (blockComment) {
					if (c == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/') {
						blockComment = false;
						i++;
					}
				} else {
					if (c == '/' && i + 1 < str.length() && str.charAt(i + 1) == '/') {
						break;
					}

					if (c == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*') {
						blockComment = true;
						i++;
					} else {
						sb.append(c);
					}
				}
			}

			if (!blockComment && sb.length() > 0) {
				list.add(sb.toString());
				sb = new StringBuilder();
			}

		}
		return list;
	}

}
