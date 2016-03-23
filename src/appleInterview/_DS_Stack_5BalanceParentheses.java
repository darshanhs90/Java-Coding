package appleInterview;

import java.util.Stack;

public class _DS_Stack_5BalanceParentheses {
	public static void main(String[] args) {
		System.out.println(balanceParentheses("[()]{}{[()()]()}"));
		System.out.println(balanceParentheses("[(])"));
	}

	private static boolean balanceParentheses(String string) {
		Stack<Character> charStack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			switch(c){
			case '(':charStack.push(c);break;
			case '{':charStack.push(c);break;
			case '[':charStack.push(c);break;
			case ')':if(charStack.peek()!='(')return false;charStack.pop();break;
			case '}':if(charStack.peek()!='{')return false;charStack.pop();break;
			case ']':if(charStack.peek()!='[')return false;charStack.pop();break;
			default:break;
			}
		}
		return charStack.isEmpty();
	}
}
