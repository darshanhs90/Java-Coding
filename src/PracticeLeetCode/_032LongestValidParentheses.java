package PracticeLeetCode;

import java.util.Stack;

public class _032LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses("(())("));
		System.out.println(longestValidParentheses("()"));
		

	}
	public static int longestValidParentheses(String s) {
		if(s==null||s.length()<2)
			return 0;
		Stack<int[]> stack=new Stack<>();
		int maxLength=0;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='(')
			{
				stack.push(new int[]{i,0});
			}
			else{
				if(stack.isEmpty()||stack.peek()[1]==1)
				{
					stack.push(new int[]{i,1});
				}else{
					stack.pop();
					if(stack.isEmpty())
					{
						maxLength=Math.max(maxLength, i+1);
					}else{
						maxLength=Math.max(maxLength, i-stack.peek()[0]);						
					}
				}
			}
		}
		return maxLength;
	}
}

