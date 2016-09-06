package LeetCodePerformancePractice;

import java.util.Stack;

public class _020ValidParentheses {
	public static boolean isValid(String s) {
		if(s==null||s.length()==0)
			return true;
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='('||c=='{'||c=='[')
				stack.push(c);
			else{
				if(stack.isEmpty())
					return false;
				else if((c==')' && stack.peek()=='(')||
						(c==']' && stack.peek()=='[')||
						(c=='}' && stack.peek()=='{'))
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
}
