package yelpInterview;

import java.util.Stack;

public class _Stack07MinimumBrackerReversals {

	public static void main(String a[]){
		System.out.println(findBracketReversals("}{"));
		System.out.println(findBracketReversals("{{{"));
		System.out.println(findBracketReversals("{{{{"));
		System.out.println(findBracketReversals("{{{{}}"));
		System.out.println(findBracketReversals("}{{}}{{{"));

	}

	private static int  findBracketReversals(String string) {
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i)=='{')
			{
				stack.push('{');
			}
			else{
				if(!stack.isEmpty() && stack.peek()=='{')
					stack.pop();
				else{
					stack.push(string.charAt(i));
				}
			}
		}

		int openingBraceCount=0;
		int size=stack.size();
		while(!stack.isEmpty()){
			if(stack.pop()=='{')
				openingBraceCount++;
		}
		return size/2+openingBraceCount%2;
	}



}

