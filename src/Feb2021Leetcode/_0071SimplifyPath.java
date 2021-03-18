package Feb2021Leetcode;

import java.util.ArrayList;
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
		path = path.replaceAll("//", "/");
		String arr[] = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (String str : arr) {
			if (str.length() != 0 && !str.equals(".")) {
				if (str.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else {
					stack.push(str);
				}
			}
		}

		List<String> list = new ArrayList<String>();
		while (!stack.isEmpty()) {
			list.add(0, stack.pop());
		}
		return "/" + String.join("/", list);
	}
}
