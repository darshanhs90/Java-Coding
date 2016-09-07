package LeetCodePerformancePractice;

import java.util.Stack;

public class _032LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses("(()"));

	}

	public static int longestValidParentheses(String s) {
		Stack<int[]> stack=new Stack<>();
		int maxLength=Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='(')
				stack.push(new int[]{i,0});
			else{
				if(stack.isEmpty()||stack.peek()[1]==1)
				{
					stack.push(new int[]{i,1});
				}
				else{
					stack.pop();
					int currLength=0;
					if(stack.isEmpty())
					{
						currLength=i+1;
					}
					else{
						currLength=i-stack.peek()[0];
					}
					maxLength=Math.max(currLength, maxLength);
				}
			}
		}
		return maxLength;
	}
}

