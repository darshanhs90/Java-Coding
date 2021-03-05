package FacebookPortalPrep;

import java.util.Stack;

public class _0021Stacks_BalancedBrackets {

	public static void main(String[] args) {
		System.out.println(isBalanced("{[()]}"));
		System.out.println(isBalanced("{}()"));
		System.out.println(isBalanced("{(})"));
		System.out.println(isBalanced(")"));
	}

	public static boolean isBalanced(String s) {
		// Write your code here

		if (s.length() == 1)
			return false;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char c1 = stack.peek();
				if ((c == ')' && c1 != '(') || (c == ']' && c1 != '[') || (c == '}' && c1 != '{'))
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
