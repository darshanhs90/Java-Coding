package May2021GoogLeetcode;

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
		List<String> output = new ArrayList<String>();

		boolean blockCommentStart = false;
		for (String str : source) {

			StringBuilder sb = new StringBuilder();
			int slashIndex = str.indexOf("//");
			int multiIndexStart = str.indexOf("/*");
			int multiIndexEnd = str.indexOf("*/");
			if (blockCommentStart) {
				if (multiIndexEnd == -1) {
					continue;
				} else {
					sb.append(str.substring(multiIndexEnd + 2));
					blockCommentStart = false;
				}
			} else {
				if (slashIndex == -1 && multiIndexStart == -1) {
					output.add(str);
				} else {
					if (slashIndex != -1 && multiIndexStart != -1) {
						if (slashIndex < multiIndexStart) {
							sb.append(str.substring(0, slashIndex));
						} else {
							blockCommentStart = true;
							sb.append(str.substring(0, multiIndexStart));

							if (multiIndexEnd != -1 && multiIndexEnd >= multiIndexStart + 2) {
								sb.append(str.substring(multiIndexEnd + 2));
								blockCommentStart = false;
							}
						}
					} else if (slashIndex != -1) {
						sb.append(str.substring(0, slashIndex));
					} else {
						blockCommentStart = true;
						sb.append(str.substring(0, multiIndexStart));

						if (multiIndexEnd != -1 && multiIndexEnd >= multiIndexStart + 2) {
							sb.append(str.substring(multiIndexEnd + 2));
							blockCommentStart = false;
						}
					}
				}
			}

			if (sb.length() != 0)
				output.add(sb.toString());
		}
		return output;
	}

}
