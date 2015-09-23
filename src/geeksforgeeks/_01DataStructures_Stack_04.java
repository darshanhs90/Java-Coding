package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;



/*
 * http://geeksquiz.com/stack-set-2-infix-to-postfix/
 * Infix to Postfix
 */;
 public class _01DataStructures_Stack_04 {	 
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString="a+b*(c^d-e)^(f+g*h)-i";//scanner.nextLine();
		 scanner.close();
		 //abcd^e-fgh*+^*+i-
		 System.out.println(convertToPostfix(inputString));
	 }

	 private static String convertToPostfix(String inputString) {
		 Stack<Character> stack=new Stack<Character>();
		 StringBuilder sb=new StringBuilder();
		 HashMap<Character,Integer> precedenceMap=new HashMap<Character,Integer>();
		 precedenceMap.put('+',1);
		 precedenceMap.put('-',1);
		 precedenceMap.put('*',2);
		 precedenceMap.put('/',3);
		 precedenceMap.put('^',4);
		 precedenceMap.put('(',5);
		 precedenceMap.put(')',5);
		 
		 for (int i = 0; i < inputString.length(); i++) {
			 char element=inputString.charAt(i);
			 if((element+"").matches("^[a-z0-9]"))
			 {
				System.out.print(element+"//");
			 }
			 else{
				 if(element=='(')
					 stack.push('(');
				 else if(element==')')
				 {
					 int poppedElem=stack.pop();
					 while(poppedElem!='('){
						 poppedElem=stack.pop();
						 System.out.print(poppedElem);
					 }
					 System.out.print(poppedElem+"//");
				 }
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 if(stack.isEmpty())
					 stack.push(element);
				 else 
				 {
					 char poppedElement=stack.peek();
					 int poppedPrecedence=precedenceMap.get(poppedElement);
					 if(poppedPrecedence<precedenceMap.get(element))
					 {
						 stack.push(element);
					 }
					 else{
						 while(!stack.isEmpty()){
							 if(precedenceMap.get(stack.peek())<=precedenceMap.get(element)){
								 stack.pop();
								 stack.push(element);
								 break;
							 }
						 }
					 }
					 
					 
				 }
				 
			 }



		 }




		 return null;
	 }
 }
