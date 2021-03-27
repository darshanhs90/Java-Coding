package Mar2021Leetcode;

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
		String[] strArray = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < strArray.length; i++) {
			String str = strArray[i].trim();
			if (str.length() > 0) {
				if (str.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (str.equals(".")) {
					continue;
				} else {
					stack.push(str);
				}
			}
		}
		StringBuilder sb = new StringBuilder("");
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
		}
		sb.insert(0, "/");
		return sb.toString().replaceAll("//", "/");
	}
}
