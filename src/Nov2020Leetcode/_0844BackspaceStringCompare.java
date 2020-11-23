package Nov2020Leetcode;

import java.util.Stack;

public class _0844BackspaceStringCompare {
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> stack1 = getStack(S);
		Stack<Character> stack2 = getStack(T);
		if (stack1.size() != stack2.size())
			return false;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.pop() != stack2.pop())
				return false;
		}
		return true;

	}

	public static Stack<Character> getStack(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '#' && !stack.isEmpty()) {
				stack.pop();
			} else if (c != '#') {
				stack.push(c);
			}
		}
		return stack;
	}
}
