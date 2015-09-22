package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;



/*
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * Check for balanced parentheses in an expression
 */;
 public class _01DataStructures_Stack_03 {	 
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();//"[(])";//"[()]{}{[()()]()}";
		 scanner.close();
		 System.out.println(checkParentheses(inputString));
	 }

	 private static boolean checkParentheses(String inputString) {
		 Stack<Character> charStack=new Stack<Character>();
		 for (int i = 0; i < inputString.length(); i++) {
			 char element=inputString.charAt(i);
			 if(element=='[' || element=='{'||element=='(')
			 {
				 charStack.push(element);
			 }
			 else{
				 char poppedElement=charStack.pop();
				 if((element==']' && poppedElement!='[')||
						 (element=='}' && poppedElement!='{')||
						 (element==')' && poppedElement!='('))
				 {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
 }
