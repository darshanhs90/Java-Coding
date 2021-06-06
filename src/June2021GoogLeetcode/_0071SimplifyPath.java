package June2021GoogLeetcode;

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
		path = path.replaceAll("//", "/");
		String strArr[] = path.split("/");
		for (String str : strArr) {
			if (str.equals(".") || str.length() == 0)
				continue;

			if (str.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(str);
			}
		}

		List<String> list = new ArrayList<String>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		Collections.reverse(list);

		StringBuilder sb = new StringBuilder(String.join("/", list));
		if (sb.length() > 0 && sb.charAt(0) == '/')
			return sb.toString();

		return "/" + sb.toString();
	}
}
