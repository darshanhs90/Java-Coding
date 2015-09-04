package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-22/
 * Code for converting floating point decimal number to binary numbers.
 * If the number cannot be converted, state so.
 */;
 public class _01AmazonInterview_22_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Float inputNumber=Float.parseFloat(scanner.nextLine());
		 scanner.close();
		 System.out.println(inputNumber);
		 convertToBinary(inputNumber);
	 }

	 private static void convertToBinary(Float inputNumber) {
		 String inputString=String.valueOf(inputNumber);
		 Integer numberPart=Integer.parseInt(inputString.substring(0,inputString.indexOf('.')));
		 Float decimalPart=Float.parseFloat(inputString.substring(inputString.indexOf('.'),inputString.length()));
		 String strBefore=getBinaryBefore(numberPart);
		 String strAfter=getBinaryAfter(decimalPart);
		 System.out.println(strBefore+"."+strAfter);		
	 }

	 private static String getBinaryAfter(Float decimalPart) {
		 Stack<String> stack=new Stack<String>();	
		 StringBuffer sb=new StringBuffer();
		 while(decimalPart!=1.0){
			 decimalPart=decimalPart*2;
			 stack.push(decimalPart.toString().split("")[1]);
			 sb.append(decimalPart.toString().split("")[1]);
			 decimalPart=Float.parseFloat(decimalPart.toString().substring(decimalPart.toString().indexOf('.'),decimalPart.toString().length()));
			 if(stack.size()>15)
				 break;
		 }
		 return sb.toString();
	 }

	 private static String getBinaryBefore(Integer numberPart) {
		 Stack<Integer> stack=new Stack<Integer>();	
		 while(numberPart!=0){
			 stack.push(numberPart%2);
			 numberPart/=2;
		 }
		 StringBuffer sb=new StringBuffer();
		 while(!stack.isEmpty()){
			 sb.append(stack.pop());
		 }
		 return sb.toString();
	 }
 }