package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;



/*
 * http://geeksquiz.com/stack-set-3-reverse-string-using-stack/
 * Reverse a string using stack
 */;
 public class _01DataStructures_Stack_01 {	 
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 System.out.println(reverseString(inputString));

	 }

	 private static String reverseString(String inputString) {
		 Stack<Character> characterStack=new Stack<Character>();
		 for (int i = 0; i < inputString.length(); i++) {
			 characterStack.push(inputString.charAt(i));
		 }
		 String outputString="";
		 while(!characterStack.isEmpty())
		 {
			 outputString+=characterStack.pop();
		 }
		 return outputString;
	 }
 }
