package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8/
 *  Given an array of positive integers, find the max no that can be formed by any permutation of the arrangement
 */;
 public class _01AmazonInterview_08_03 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 for (int i = 0; i < size; i++) {
			 inputArray[i]=new Random().nextInt(size*size);
		 }
		 for (int i = 0; i < size; i++) {
			 System.out.print(inputArray[i]+",");
		 }
		 System.out.println(arrangeElements(inputArray));
		 System.out.println(arrangeNumbers(inputArray));
	 }

	 private static String arrangeNumbers(int[] inputArray) {
		 HashMap<Integer,Integer> elementMap=new HashMap<Integer,Integer>();
		 for (int i = 0; i < inputArray.length; i++) {
			 String inputElementArray[]=String.valueOf(inputArray[i]).trim().split("");
			 for (int j = 1; j < inputElementArray.length; j++) {
				 int value=Integer.parseInt(inputElementArray[j]);
				 if(!elementMap.containsKey(value)){
					 elementMap.put(value, 1);
				 }
				 else{
					 elementMap.put(value,elementMap.get(value)+1);
				 }
			 }
		 }
		 StringBuilder outputString=new StringBuilder();
		 for (int j = 9; j >=0 ; j--) {
			 if(elementMap.containsKey(j)){
				 int elementCount=elementMap.get(j);
				 for (int k = 0; k < elementCount; k++) {
					 outputString.append(j+"");
				 }
			 }
		 }
		 return  outputString.toString();
	 }

	 private static String arrangeElements(int[] inputArray) {
		 /*
		 	1,8,9
		 	94,99
		 	120,960,989
		 	
		 	=>9/99/989/960/94/8/120/1
			
		  */
		 return  "arrangeelements";
	 }
 }