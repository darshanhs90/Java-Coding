package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Convert postfix to infix in which the result must be having minimum number of braces i.e apply braces whenever necessary.
 */;
 public class _01AmazonInterview_18_02 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();//"x y ^ 5 z * / 10 +"
		 scanner.close();
		 System.out.println(convertToInfix(inputString));
	 }

	 private static String convertToInfix(String inputString) {
		 int index=0;
		 Stack<String> stack=new Stack<String>();
		 String inputStringArray[]=inputString.split(" ");
		 while(index<inputStringArray.length){
			 String characterElement=inputStringArray[index];
			 char character=characterElement.charAt(0);
			 if(character=='^'||character=='+'||character=='-'||character=='/'||character=='*')
			 {
				 String first=stack.pop();
				 String second=stack.pop();
				 
				 stack.push("("+second+character+first+")");	
			 }
			 else{
				 stack.push(characterElement);
			 }
			 index++;
		 }
		 return stack.pop();
	 }
 }