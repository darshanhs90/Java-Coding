package LeetCodePerformancePractice;

import java.util.Stack;

public class _032LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses("(()"));

	}
	static class CharNode
	{
		int value;
		int position;
		public CharNode(int position,int value) {
			this.value=value;
			this.position=position;
		}
	}
	public static int longestValidParentheses(String s) {
		if(s==null||s.length()<=1)
			return 0;
		int result=0;
		Stack<CharNode> stack=new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='(')
				stack.push(new CharNode(i,0));
			else{
				if(stack.isEmpty()||stack.peek().value==1)
				{
					stack.push(new CharNode(i,1));
				}
				else{
					stack.pop();
					int currLength=0;
					if(stack.isEmpty())
					{
						currLength=i+1;
					}
					else{
						currLength=i-stack.peek().position;
					}
					result=Math.max(result, currLength);
				}
			}
		}
		return result;
	}
}

