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
		 String inputString="darshan";//scanner.nextLine();
		 scanner.close();
		 Stack<Character> stack=new Stack<Character>();
		 stack=addToStack(inputString,stack);
		 System.out.println(stack.toString());
		 reverseStackRecursion(stack);
		 System.out.println(stack.toString());

	 }

	 private static void reverseStackRecursion(Stack<Character> stack) {
		 if(stack.isEmpty()) 
			 return;
	     Character temp = stack.pop();
	     reverseStackRecursion(stack);
	     insert_at_bottom(stack,temp);
	 }

	 private static void insert_at_bottom(Stack<Character> stack, Character data) {
		 if(stack.isEmpty()){
	          stack.push(data);
	          return;
	     }
	     Character temp=stack.pop();
	     insert_at_bottom(stack,data);
	     stack.push(temp);
	}

	private static Stack<Character> addToStack(String inputString,Stack<Character> stack) {
		 for (int i = 0; i < inputString.length(); i++) {
			 stack.push(inputString.charAt(i));
		 }
		 return stack;
	 }


 }
