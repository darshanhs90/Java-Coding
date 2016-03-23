package appleInterview;

import java.util.Stack;

public class _DS_Stack_3ReverseStringUsingStack {
	public static void main(String[] args) {
		String string="malayalama";
		System.out.println(reverseString(string));
	}

	private static String reverseString(String string) {
		StringBuilder sb=new StringBuilder("");
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));
		}
		while(!stack.isEmpty())
		{
			sb.append(stack.pop());
		}
		return sb.toString();
	}




}
