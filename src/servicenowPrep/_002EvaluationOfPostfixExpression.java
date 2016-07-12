package servicenowPrep;

import java.util.Stack;

public class _002EvaluationOfPostfixExpression {
	public static void main(String[] args) {
		System.out.println(evaluatePostfix("231*+9-"));
	}

	private static int evaluatePostfix(String string) {
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(Character.isDigit(c))
			{
				stack.push(Integer.parseInt(c+""));
			}
			else{
				if(!stack.isEmpty())
				{
					int valueA=stack.pop();
					if(!stack.isEmpty())
					{
						int valueB=stack.pop();
						if(c=='+')
							stack.push(valueA+valueB);
						else if(c=='-')
							stack.push(-valueA+valueB);
						else if(c=='/')
							stack.push(valueB/valueA);
						else if(c=='*')
							stack.push(valueA*valueB);
					}
				}
			}
		}
		return stack.pop();
	}


}
