package servicenowPrep;

import java.util.Stack;

public class _004BalancedParentheses {
	public static void main(String[] args) {
		System.out.println(evaluateParentheses("[()]{}{[()()]()}"));
		System.out.println(evaluateParentheses("[(])"));
	}

	private static boolean evaluateParentheses(String string) {
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(c=='('||c=='{'||c=='[')
				stack.push(c);
			else
			{
				if(stack.isEmpty())
					return false;
				else
				{
					if((stack.peek()=='(' && c==')')
							||(stack.peek()=='{' && c=='}')
							||(stack.peek()=='[' && c==']'))
					{
						stack.pop();
					}
					else
						return false;
				}
			}
		}
		return true;
	}





}
