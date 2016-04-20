package yelpInterview;

import java.util.Stack;

public class _Stack02ReverseStringStack {
	public static void main(String a[]){
		System.out.println(evaluate("231*+9-"));
	}

	private static String evaluate(String string) {
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));
		}
		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}

