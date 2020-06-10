package PracticeLeetCode;

import java.util.Stack;

public class _020ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("()[]{}}"));
		System.out.println(isValid("{[]}"));
	}

	public static boolean isValid(String s) {
		if(s == null || s.length() == 0)
		{
			return true;	
		}
		if(s.length()%2 == 1)
		{
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(stack.isEmpty() || c == '(' || c == '[' || c == '{')
			{
				stack.push(c);
			}
			else {
				char poppedChar = stack.pop();
				if(!((c == ')' && poppedChar == '(') ||
						(c == ']' && poppedChar == '[') ||
						(c == '}' && poppedChar == '{'))){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
