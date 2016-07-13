package servicenowPrep;

import java.util.Stack;

public class _003ReverseAStringUsingStack {
	public static void main(String[] args) {
		System.out.println(reverseString("GeeksQuiz"));
	}

	private static String reverseString(String string) {
		Stack<Character> stack=new Stack<>();
		StringBuilder sb=new StringBuilder("");                                                                                                                       
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
