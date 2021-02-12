package Jan2021Leetcode;

import java.util.Stack;

public class _0844BackspaceStringCompare {
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}

	public static boolean backspaceCompare(String S, String T) {
		if (S == null && T == null)
			return true;
		else if (S == null || T == null)
			return false;

		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '#') {
				if (!stack1.isEmpty())
					stack1.pop();
			} else {
				stack1.push(c);
			}
		}
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (c == '#') {
				if (!stack2.isEmpty())
					stack2.pop();
			} else {
				stack2.push(c);
			}
		}
		
		if(stack1.size()!= stack2.size())
			return false;
		
		while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek())
		{
			stack1.pop();
			stack2.pop();
		}
		
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
