package appleInterview;

import java.util.Stack;

public class _DS_Stack_1InfixToPostfix {
	public static void main(String[] args) {
		String infix="a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convertToPostfix(infix));
	}

	private static String convertToPostfix(String infix) {
		StringBuilder output=new StringBuilder("");
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char c=infix.charAt(i);
			switch(c)
			{
			case '+':handleStack(output, stack, c);
			break;
			case '-':handleStack(output, stack, c);
			break;
			case '*':handleStack(output, stack, c);
			break;
			case '/':handleStack(output, stack, c);
			break;
			case '(':stack.push(c);
			break;
			case ')':while(!stack.isEmpty() && stack.peek()!='(')
			{
				output.append(stack.pop());
			}
			break;
			default:output.append(c);
			break;
			}
		}
		return output.toString();
	}

	private static void handleStack(StringBuilder output, Stack<Character> stack, char c) {
		if(!stack.isEmpty())
		{	
			boolean b=checkPrec(c,stack.peek());
			if(b)
			{
				stack.push(c);
			}
			else{
				while(!stack.isEmpty() && checkPrec(c,stack.peek())){
					output.append(stack.pop());
				}
				stack.push(c);
			}
		}
		else{
			stack.push(c);
		}
	}

	private static boolean checkPrec(char c, Character peek) {
		return (c>peek);
	}
}
