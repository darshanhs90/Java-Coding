package Leetcode2020Nov;

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
		String[] pathArr = path.split("/");
		for (int i = 0; i < pathArr.length; i++) {
			String currPath = pathArr[i].trim();
			if (currPath.contentEquals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else if (currPath.length() == 0 || currPath.contentEquals(".") || currPath.contentEquals("/")) {
				// do nothing
			} else {
				stack.push(currPath);
			}
		}
		Stack<String> reverseStack = new Stack<String>();
		while (!stack.isEmpty()) {
			reverseStack.push(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		sb = sb.append("/");
		while (!reverseStack.isEmpty()) {
			sb = sb.append(reverseStack.pop());
			sb = sb.append("/");
		}
		return sb.length() > 1 ? sb.substring(0, sb.length() - 1).toString() : sb.toString();
	}
}
