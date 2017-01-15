package PracticeLeetCode;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
	public static int evalRPN(String[] tokens) {
		if(tokens==null||tokens.length==0)
			return 0;
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].contentEquals("+"))
			{
				stack.push(stack.pop()+stack.pop());
			}
			else if(tokens[i].contentEquals("-"))
			{
				stack.push(stack.pop()-stack.pop());
			}
			else if(tokens[i].contentEquals("/"))
			{
				int numA=stack.pop();
				int numB=stack.pop();
				
				stack.push(numB/numA);
			}
			else if(tokens[i].contentEquals("*"))
			{
				stack.push(stack.pop()*stack.pop());
			}
			else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.isEmpty()?0:stack.peek();
	}
}