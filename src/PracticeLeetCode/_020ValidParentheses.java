package PracticeLeetCode;

import java.util.Stack;

public class _020ValidParentheses {
	public static boolean isValid(String s) {
		if(s==null||s.length()==0)
			return true;
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='('||c=='{'||c=='[')
			{
				stack.push(c);
			}
			else {
				if(stack.isEmpty())
					return false;
				else if(!((stack.peek()=='(' && c==')')||(stack.peek()=='[' && c==']')||(stack.peek()=='{' && c=='}'))){
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
