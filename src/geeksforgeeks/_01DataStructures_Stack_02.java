package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;



/*
 * http://www.geeksforgeeks.org/archives/6921
 * Reverse a stack using recursion
 */;
 public class _01DataStructures_Stack_02 {	 
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 Stack<Character> stack=new Stack<Character>();
		 stack=addToStack(inputString,stack);
		 //reverseStackRecursion(stack,"");
	 }
	 private static boolean emptyFlag=false;
	 private static void reverseStackRecursion(Stack<Character> stack,Character c) {
		 
	 }

	 private static Stack<Character> addToStack(String inputString,Stack<Character> stack) {
		 for (int i = 0; i < inputString.length(); i++) {
			 stack.push(inputString.charAt(i));
		 }
		 return stack;
	 }


 }
