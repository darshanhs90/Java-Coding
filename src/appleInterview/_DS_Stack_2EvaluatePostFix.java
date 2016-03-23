package appleInterview;

import java.util.Stack;

public class _DS_Stack_2EvaluatePostFix {
	public static void main(String[] args) {
		String postfix="231*+9-";
		System.out.println(evaluatePostfix(postfix));
	}
	private static int evaluatePostfix(String postfix) {
		Stack<Integer> charStack=new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c=postfix.charAt(i);
			switch(c){
			case '+':performOperation(charStack,c);break;
			case '-':performOperation(charStack,c);break;
			case '*':performOperation(charStack,c);break;
			case '/':performOperation(charStack,c);break;
			default:charStack.push(Integer.parseInt(c+""));
			break;
			}
		}
		return charStack.isEmpty()?0:Integer.parseInt(charStack.peek()+"");
	}
	private static void performOperation(Stack<Integer> charStack,Character c) {
		if(!charStack.isEmpty())
		{	
			int a=Integer.parseInt(charStack.pop()+"");
			if(!charStack.isEmpty())
			{
				int b=Integer.parseInt(charStack.pop()+"");
				switch(c){
				case '+':charStack.push((a+b));break;
				case '-':charStack.push((b-a));break;
				case '*':charStack.push((a*b));break;
				case '/':charStack.push((a/b));break;
				default:break;
				}
			}
		}
	}
}
