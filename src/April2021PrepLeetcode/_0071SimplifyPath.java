package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _0071SimplifyPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] str = path.split("/");
		for (int i = 0; i < str.length; i++) {
			String currString = str[i];
			if (currString.length() == 0)
				continue;
			if (currString.equals(".")) {
				// no op
			} else if (currString.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(currString);
			}
		}
		List<String> list = new ArrayList<String>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		Collections.reverse(list);
		return "/" + String.join("/", list);
	}
}
