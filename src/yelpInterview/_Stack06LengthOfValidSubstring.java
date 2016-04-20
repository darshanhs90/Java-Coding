package yelpInterview;

import java.util.Stack;

public class _Stack06LengthOfValidSubstring {

	public static void main(String a[]){
		System.out.println(findLength("((()"));
		System.out.println(findLength(")()())"));
		System.out.println(findLength("()(()))))"));
	}

	private static int findLength(String str) {
		Stack<Integer> stack=new Stack<>();
		int result = 0;
		stack.push(-1);
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			if(c=='(')
			{
				stack.push(i);
			}
			else{
				//if(!stack.isEmpty()){
					stack.pop();
					if (!stack.isEmpty())
						result = Math.max(result, i - stack.peek());
					else stack.push(i);
				//}
			}
		}
		return result;
	}


}

