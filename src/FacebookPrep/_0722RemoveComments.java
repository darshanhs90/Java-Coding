package FacebookPrep;

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
		
	}

}
