package PracticeLeetCode;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if(tokens[i].contentEquals("+")
					||tokens[i].contentEquals("-")
					||tokens[i].contentEquals("/")
					||tokens[i].contentEquals("*"))
			{
				int a=0,b=0;
				switch(tokens[i]){
				case "+":
					a=stack.pop();
					b=stack.pop();
					stack.push(a+b);
					break;
				case "-":
					a=stack.pop();
					b=stack.pop();
					stack.push(b-a);
					break;
				case "/":
					a=stack.pop();
					b=stack.pop();
					stack.push(b/a);
					break;
				case "*":
					a=stack.pop();
					b=stack.pop();
					stack.push(a*b);
					break;
				}
			}
			else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}