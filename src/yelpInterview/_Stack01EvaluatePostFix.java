package yelpInterview;

import java.util.Stack;

public class _Stack01EvaluatePostFix {
	public static void main(String a[]){
		System.out.println(evaluate("231*+9-"));
	}

	private static int evaluate(String string) {
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(Character.isDigit(c))
			{
				stack.push(Integer.parseInt(c+""));
			}
			else{
				if(stack.isEmpty())
				{
					return -1;
				}
				else{
					int value1=stack.pop();
					if(stack.isEmpty())
					{
						return -1;
					}
					else{
						int value2=stack.pop();
						stack.push(handle(value1,value2,c));
					}
				}
			}
		}
		return stack.isEmpty()?-1:stack.pop();
	}

	private static Integer handle(int value1, int value2, char c) {
		switch(c){
		case '+':return value1+value2;
		case '-':return value1-value2;
		case '/':return value1/value2;
		case '*':return value1*value2;
		default:break;
		}
		return null;
	}
}

