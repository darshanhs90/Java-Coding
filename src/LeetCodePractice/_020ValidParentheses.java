package LeetCodePractice;

import java.util.Stack;

public class _020ValidParentheses {



	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("(]"));
	}



	public static boolean isValid(String s) {
		Stack<Character> charStack=new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			switch (c){
			case '{':charStack.push(c);break;
			case '(':charStack.push(c);break;
			case '[':charStack.push(c);break;
			case ']':if(charStack.isEmpty())return false;char poppedChar=charStack.pop();
			if(poppedChar!='[')return false;break;
			case '}':if(charStack.isEmpty())return false;poppedChar=charStack.pop();
			if(poppedChar!='{')return false;break;
			case ')':if(charStack.isEmpty())return false;poppedChar=charStack.pop();
			if(poppedChar!='(')return false;break;
			default:break;
			}
		}
		return charStack.isEmpty()?true:false;
	}
}
