package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-27/
 * http://www.geeksforgeeks.org/counting-inversions/
 * Write a program to find number of inversions in an array.
 * Example- Array 2, 5, 3, 1,10
 * Inversions (2,1) , (5,1), (3,1), (5,3)
 * Answer will be – 4
 */;
 public class _01AmazonInterview_27_02 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=buildInputArray(size);
		 System.out.println(Arrays.toString(inputArray));
		 ArrayList<String> outputList=getInversionsLong(inputArray);
		 System.out.println(Arrays.toString(outputList.toArray()));
		 //outputList=getInversionsShort(inputArray);
		 //System.out.println(Arrays.toString(outputList.toArray()));

	 }

	 private static ArrayList<String> getInversionsShort(int[] inputArray) {
		 ArrayList<String> outputList=new ArrayList<String>();
		 //merge sort here
		 
		 
		 return null;
	 }

	 private static ArrayList<String> getInversionsLong(int[] inputArray) {
		 ArrayList<String> outputList=new ArrayList<String>();
		 for (int i = 0; i < inputArray.length; i++) {
			 for (int j = i+1; j < inputArray.length; j++) {
				 if(inputArray[j]<inputArray[i])
				 {
					 outputList.add(inputArray[i]+","+inputArray[j]);
				 }
			 }
		 }
		 return outputList;
	 }

	 private static int[] buildInputArray(Integer size) {
		 int[] inputArray=new int[size];
		 for (int i = 0; i < size; i++) {
			 inputArray[i]=new Random().nextInt(size*3);
		 }
		 return inputArray;
	 }




 }