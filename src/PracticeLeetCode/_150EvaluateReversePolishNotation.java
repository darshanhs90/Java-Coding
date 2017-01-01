package PracticeLeetCode;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].contentEquals("+")){
				int num1=stack.pop();
				int num2=stack.pop();
				stack.push(num1+num2);
			}else if(tokens[i].contentEquals("-")){
				int num1=stack.pop();
				int num2=stack.pop();
				stack.push(num2-num1);
			}else if(tokens[i].contentEquals("*")){
				int num1=stack.pop();
				int num2=stack.pop();
				stack.push(num1*num2);
			}else if(tokens[i].contentEquals("/")){
				int num1=stack.pop();
				int num2=stack.pop();
				stack.push(num2/num1);
			}
			else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.peek();
	}
}