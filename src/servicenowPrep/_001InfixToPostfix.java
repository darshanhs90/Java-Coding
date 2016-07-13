package servicenowPrep;

import java.util.Stack;

public class _001InfixToPostfix {
	public static void main(String[] args) {
		System.out.println(convertToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
	}

	private static String convertToPostfix(String string) {
		StringBuilder sb=new StringBuilder("");
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(Character.isLetter(c))
			{
				sb.append(c);
			}
			else{
				if(c=='(')
					stack.push(c);
				else if(c==')')
				{
					while(!stack.isEmpty())
					{
						sb.append(stack.pop());
					}
				}
				else{
					while(true && !stack.isEmpty())
					{
						char c1=stack.peek();
						if(c1>c)
						{
							sb.append(stack.pop());
						}
						else{
							stack.push(c);
							break;
						}
					}
					if(stack.isEmpty())
						stack.push(c);
				}
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}
}
