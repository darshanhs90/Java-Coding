package PracticeLeetCode;

import java.util.Stack;

public class _020ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> stack=new Stack<>();
		if(s==null||s.length()==0)
			return true;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='('||c=='['||c=='{'){
				stack.push(c);
			}
			else{
				if(stack.isEmpty())
					return false;
				char c1=stack.pop();
				if(!((c1=='(' && c==')')||
						(c1=='{' && c=='}')||
						(c1=='[' && c==']')))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
