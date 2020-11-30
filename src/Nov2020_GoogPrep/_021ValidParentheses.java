package Nov2020_GoogPrep;

import java.util.Stack;

public class _021ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty())
					return false;
				char popChar = stack.pop();
				if ((c == ')' && popChar != '(') || (c == '}' && popChar != '{') || (c == ']' && popChar != '['))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
