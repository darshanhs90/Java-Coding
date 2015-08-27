package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-2/
 * Parenthesis checker.
 */
public class _01AmazonInterview_03_02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		scanner.close();
		System.out.println("Parenthesis check : "+checkParentheses(inputString));
	}

	private static boolean checkParentheses(String inputString) {
		// TODO Auto-generated method stub
		Stack<Character> stack=new Stack<Character>();
		for (int i = 0; i < inputString.length(); i++) {
			Character c= inputString.charAt(i);
			if((c=='(')||(c=='{')||(c=='[')){
				stack.push(c);
			}
			else if((c==')')||(c=='}')||(c==']')){
				if(!stack.isEmpty() && (stack.peek()=='(' && c==')')||(stack.peek()=='{' && c=='}')||(stack.peek()=='[' && c==']')){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}
		return true;
	}


}