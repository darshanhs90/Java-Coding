package leetCode;

import java.util.Stack;

/*
 * Link : https://leetcode.com/problems/valid-parentheses/
 */

public class _020ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> characterStack=new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char element=s.charAt(i);
			if(element=='('||element=='{'||element=='[')
			{
				characterStack.push(element);
			}
			else{
				if(!characterStack.isEmpty()){
					char poppedElement=characterStack.pop();
					if(!((element==')' && poppedElement=='(')
							||(element=='}' && poppedElement=='{')
							||(element==']' && poppedElement=='[')))
						return false;
				}
				else{
					return false;
				}
			}
		}
		return characterStack.isEmpty()?true:false;
	}
	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
}