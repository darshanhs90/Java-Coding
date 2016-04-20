package yelpInterview;

import java.util.Stack;

public class _Stack04BalanceParenthesesCheck {

	public static void main(String a[]){
		System.out.println(isValidParentheses("[()]{}{[()()]()}"));
		System.out.println(isValidParentheses("[(])"));

	}

	private static boolean isValidParentheses(String string) {
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			switch(c){
			case '{':stack.push(c);break;
			case '(':stack.push(c);break;
			case '[':stack.push(c);break;
			case '}':
				if(stack.peek()=='{'){
					stack.pop();
					break;
				}
				else
					return false;
			case ']':
				if(stack.peek()=='['){
					stack.pop();
					break;
				}
				else
					return false;
			case ')':
				if(stack.peek()=='('){
					stack.pop();
					break;
				}
				else
					return false;

			}
		}
		return stack.isEmpty();
	}




}

