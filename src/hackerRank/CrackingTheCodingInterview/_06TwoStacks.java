package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;
import java.util.Stack;

public class _06TwoStacks {

	public static boolean isBalanced(String expression) {
		Stack<Character> stack=new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c=expression.charAt(i);
			if(c=='('||c=='{'||c=='[')
			{
				stack.push(c);
			}
			else{
				if(stack.isEmpty())
				{
					return false;
				}
				else{
					char c1=stack.pop();
					if(!((c==')' && c1=='(')||
							(c==']' && c1=='[')||
							(c=='}' && c1=='{')))
						return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			boolean answer = isBalanced(expression);
			if(answer)
				System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
