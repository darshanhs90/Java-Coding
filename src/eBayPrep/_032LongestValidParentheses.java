package eBayPrep;

import java.util.Stack;

public class _032LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())"));
		/*System.out.println(longestValidParentheses("()()"));
		System.out.println(longestValidParentheses("(()"));*/
	}
	static class Element{
		int start,end;
		public Element(int start,int end) {
			this.start=start;
			this.end=end;
		}
	}
	public static int longestValidParentheses(String s) {
		Stack<Element> stack = new Stack<Element>();
		int result = 0;

		for(int i=0; i<=s.length()-1; i++){
			char c = s.charAt(i);
			if(c=='('){
				stack.push(new Element(i, 0));
			}else{
				if(stack.empty()||stack.peek().end==1){
					stack.push(new Element(i, 1));
				}else{
					stack.pop();
					int currentLen=0;
					if(stack.empty()){
						currentLen = i+1;
					}else{
						currentLen = i-stack.peek().start;
					}
					result = Math.max(result, currentLen);
				}
			}
		}
		return result;
	}
}
