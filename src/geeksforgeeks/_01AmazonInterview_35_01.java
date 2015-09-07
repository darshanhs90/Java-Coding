package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-35/
 * Convert a n-byte integer from little endian to big endian.
 */;
 public class _01AmazonInterview_35_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer input=1234123412;//Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 System.out.println("Output string is : "+convertToBigEndianStack(input));
	 }


	 private static String convertToBigEndianStack(Integer input) {
		 String inputString=Integer.toHexString(input);
		 System.out.println("Input string is : "+inputString);
		 Stack<String> stack=new Stack<String>();
		 String outputString="";
		 for (int i = 0; i < inputString.length(); i=i+2) {
			 if(i+1<inputString.length())
				 stack.push(inputString.substring(i,i+2));
			 else
				 stack.push(inputString.substring(i,i+1));
		 }
		 while(!stack.isEmpty()){
			 outputString+=stack.pop();
		 }
		 return outputString;
	 }
 }