package Dec2020Leetcode;

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
		boolean blockStart = false;
		StringBuilder sb = new StringBuilder();
		for (String str : source) {
			if (blockStart) {
				int index = str.indexOf("*/");
				if (index > -1) {
					String strNew = str.substring(index + 2);
					blockStart = false;
					sb.append(strNew);
					if (sb.length() > 0)
						output.add(sb.toString());
				}
			} else {
				int index = str.indexOf("/*");
				if (index > -1) {
					String commentPart = str.substring(index + 2);
					int endIndex = commentPart.indexOf("*/");
					if (endIndex > -1) {
						String outputStr = str.substring(0, index) + commentPart.substring(endIndex + 2);
						if (outputStr.length() > 0)
							output.add(outputStr);
					} else {
						String strNew = str.substring(0, index);
						blockStart = true;
						sb = new StringBuilder(strNew);
					}
				} else {
					index = str.indexOf("//");
					if (index > -1) {
						String strNew = str.substring(0, index);
						if (strNew.length() > 0)
							output.add(strNew);
					} else {
						output.add(str);
					}
				}
			}
		}
		return output;
	}

}
