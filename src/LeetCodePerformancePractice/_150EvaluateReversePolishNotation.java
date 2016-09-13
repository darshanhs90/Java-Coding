package LeetCodePerformancePractice;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		
	}
	public static int evalRPN(String[] tokens) {
		if(tokens==null||tokens.length<1)
			return 0;
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String str=tokens[i];
			if(str.length()==1 && (str.contentEquals("+")||str.contentEquals("-")
					||str.contentEquals("*")||str.contentEquals("/")))
			{
				int value1=0,value2=0;
				if(!stack.isEmpty())
				{
					value1=stack.pop();
					if(!stack.isEmpty())
					{
						value2=stack.pop();
						if(str.contentEquals("+"))
							stack.push(value2+value1);
						else if(str.contentEquals("-"))
							stack.push(value2-value1);
						else if(str.contentEquals("/"))
							stack.push(value2/value1);
						else
							stack.push(value1*value2);
					}
					else
						return -1;
				}
				else
					return -1;
			}
			else{
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.pop();


	}
}
